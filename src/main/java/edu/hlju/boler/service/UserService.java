package edu.hlju.boler.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import edu.hlju.boler.dao.IRoleDao;
import edu.hlju.boler.dao.IUserDao;
import edu.hlju.boler.datadictory.UserDataDict;
import edu.hlju.boler.pojo.po.Role;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.po.UserLog;
import edu.hlju.boler.pojo.vo.BaseResponse;
import edu.hlju.boler.pojo.vo.StateResponse;
import edu.hlju.boler.service.interfaces.IUserService;
import edu.hlju.boler.util.Encrytor;

@Service("userService")
public class UserService extends BaseService implements IUserService {
    public static final String USER_OBJECT = "user";
    public static final int MAX_ERROR_TIMES = 3;
// private int errorTimes = 0;

    @Resource
    private IUserDao userDao;

    @Resource
    private IRoleDao roleDao;

    @Override
    public StateResponse login(HttpServletRequest request, User user) {
        User selected = null;
        try {
            selected = userDao.selectByEmail(user.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
            return this.getResponse(UserDataDict.REGISTER_FAILED);
        }

        boolean isCorrect = selected != null && Encrytor.encrypt(user.getPassword()).equals(selected.getPassword());
        if (!isCorrect) {
            return this.getResponse(UserDataDict.LOGIN_FAILED);
        }

        HttpSession session = request.getSession();
        session.setAttribute(USER_OBJECT, selected);

        UserDataDict state = UserDataDict.LOGIN_SUCCEED;
        this.saveUserLog(request, state.getMessage());
        return this.getResponse(state);
    }

    @Override
    public StateResponse logout(HttpServletRequest request) {
        Object user_obj = request.getSession().getAttribute(USER_OBJECT);
        UserDataDict state = null;
        if (user_obj == null) {
            state = UserDataDict.LOGOUT_FAILED;
        } else {
            User logined = (User) user_obj;
            request.getSession().removeAttribute(USER_OBJECT);
            state = UserDataDict.LOGOUT_SUCCEED;
            UserLog log = new UserLog(request.getRemoteAddr(), logined, state.getMessage());
            this.sendMessage(log);
        }
        return this.getResponse(state);
    }

    @Override
    public StateResponse modifyPassword(HttpServletRequest request, User user, String newPassword) {
        Object obj = request.getSession().getAttribute(USER_OBJECT);
        if (obj != null) {
            User logined = (User) obj;
            boolean isRight = logined.getPassword().equals(Encrytor.encrypt(logined.getPassword()));
            if (isRight) {
                logined.setPassword(newPassword);
                try {
                    userDao.updateById(logined);
                    this.saveUserLog(request, "User modify password.");
                    return this.getResponse(UserDataDict.MODIFY_PASSWD_SUCCEED);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return this.getResponse(UserDataDict.MODIFY_PASSWD_FAILED);
    }

    @Override
    public BaseResponse queryAllRoles() {
        try {
            List<Role> result = roleDao.selectAll();
            return this.getResponse(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.getResponse(UserDataDict.OPERATIING_FAILED);
    }

    @Override
    public StateResponse register(User user) {
        try {
            user.setPassword(Encrytor.encrypt(user.getPassword()));
            userDao.insert(user);
            return this.getResponse(UserDataDict.REGISTER_SUCCEED);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.getResponse(UserDataDict.REGISTER_FAILED);

    }

}
