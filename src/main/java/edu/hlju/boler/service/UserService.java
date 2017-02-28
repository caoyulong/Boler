package edu.hlju.boler.service;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import edu.hlju.boler.dao.IPermissionDao;
import edu.hlju.boler.dao.IUserDao;
import edu.hlju.boler.dao.IUserLogDao;
import edu.hlju.boler.datadictory.RegExDataDict;
import edu.hlju.boler.datadictory.UserDataDict;
import edu.hlju.boler.pojo.po.Role;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.po.UserLog;
import edu.hlju.boler.pojo.vo.StateResponse;
import edu.hlju.boler.pojo.vo.UserRole;
import edu.hlju.boler.service.interfaces.IUserService;
import edu.hlju.boler.util.Encrytor;
import edu.hlju.boler.util.LegalityVerificator;

@Service("userService")
public class UserService implements IUserService {
    public static final String USER_OBJECT = "user";
    public static final int MAX_ERROR_TIMES = 3;
    private int errorTimes = 0;
    private HttpSession session;

    @Resource
    private IUserDao userDao;

    @Resource
    private IUserLogDao userLogDao;

    @Resource
    private IPermissionDao permDao;

    @Override
    public HttpSession getSession() {
        return session;
    }

    @Override
    public StateResponse login(HttpServletRequest request, User user) {
        User selected = null;
        try {
            selected = userDao.selectByEmail(user.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
            return new StateResponse(UserDataDict.REGISTER_FAILED);
        }

        String addr = request.getRemoteAddr();
        boolean isCorrect = selected != null && Encrytor.encrypt(user.getPassword()).equals(selected.getPassword());
        if (!isCorrect) {
            return new StateResponse(UserDataDict.LOGIN_FAILED);
        }

        // TODO
        UserLog log = new UserLog(addr, selected.getId(), 1);
        session = request.getSession();
        session.setAttribute(USER_OBJECT, selected);
        return new StateResponse(UserDataDict.LOGIN_SUCCESS);
    }

    @Override
    public StateResponse register(User user, Role role) {
        if (!LegalityVerificator.isLegal(user.getEmail(), RegExDataDict.EMAIL_REGEX.getMessage())) {
            return new StateResponse(UserDataDict.REGISTER_FAILED);
        }

        try {
            user.setPassword(Encrytor.encrypt(user.getPassword()));
            userDao.insert(user);
            userDao.insertUserRole(new UserRole(user, role));
        } catch (SQLException e) {
            e.printStackTrace();
            return new StateResponse(UserDataDict.REGISTER_FAILED);
        }

        return new StateResponse(UserDataDict.REGISTER_SUCCESS);
    }

}
