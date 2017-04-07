package edu.hlju.boler.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import edu.hlju.boler.common.ResponseFactory;
import edu.hlju.boler.controller.interfaces.IControllerLog;
import edu.hlju.boler.core.message.UserLogMessageSender;
import edu.hlju.boler.datadictory.UserDataDict;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.po.UserLog;
import edu.hlju.boler.pojo.vo.StateResponse;
import edu.hlju.boler.pojo.vo.ValueResponse;

public abstract class BaseController implements IControllerLog {
    @Resource
    private ResponseFactory responseFactory;

    @Resource
    private UserLogMessageSender userLogMessageSender;

    protected ValueResponse getResponse(Object value) {
        return responseFactory.getResponse(value);
    }

    protected StateResponse getResponse(UserDataDict userDataDict) {
        return responseFactory.getResponse(userDataDict);
    }

    protected void saveUserLog(HttpServletRequest request, String message) {
        String ip = request.getRemoteAddr();
        User user = (User) request.getSession().getAttribute(UserController.USER_OBJECT);
        UserLog log = new UserLog(ip, user, new Date(), message);
        userLogMessageSender.send(log);
    }

    protected abstract void userLogging(HttpServletRequest request, String message);

}
