package edu.hlju.boler.service;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import edu.hlju.boler.core.message.MessageSender;
import edu.hlju.boler.dao.IUserDao;
import edu.hlju.boler.datadictory.UserDataDict;
import edu.hlju.boler.pojo.po.Role;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.po.UserLog;
import edu.hlju.boler.pojo.vo.StateResponse;
import edu.hlju.boler.pojo.vo.UserRole;
import edu.hlju.boler.service.interfaces.IUserService;
import edu.hlju.boler.util.Encrytor;

@Service("userService")
public class UserService implements IUserService {
    public static final String USER_OBJECT = "user";
    public static final int MAX_ERROR_TIMES = 3;
// private int errorTimes = 0;

    @Resource
    private IUserDao userDao;

    @Resource
    private MessageSender messageSender;

    @Override
    public StateResponse login(HttpServletRequest request, User user) {
        User selected = null;
        try {
            selected = userDao.selectByEmail(user.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
            return new StateResponse(UserDataDict.REGISTER_FAILED);
        }

        boolean isCorrect = selected != null && Encrytor.encrypt(user.getPassword()).equals(selected.getPassword());
        if (!isCorrect) {
            return new StateResponse(UserDataDict.LOGIN_FAILED);
        }

        HttpSession session = request.getSession();
        session.setAttribute(USER_OBJECT, selected);

        UserDataDict state = UserDataDict.LOGIN_SUCCEED;
        UserLog log = new UserLog(request.getRemoteAddr(), selected, state.getMessage());
        messageSender.send(log);
        return new StateResponse(state);
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
            messageSender.send(log);
        }
        return new StateResponse(state);
    }

    @Override
    public StateResponse register(User user, Role role) {
        try {
            user.setPassword(Encrytor.encrypt(user.getPassword()));
            userDao.insert(user);
            userDao.insertUserRole(new UserRole(user, role));
        } catch (SQLException e) {
            e.printStackTrace();
            return new StateResponse(UserDataDict.REGISTER_FAILED);
        }

        return new StateResponse(UserDataDict.REGISTER_SUCCEED);
    }

}
