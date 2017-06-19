package edu.hlju.boler.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import edu.hlju.boler.common.ResponseFactory;
import edu.hlju.boler.controller.interfaces.IControllerLog;
import edu.hlju.boler.core.message.EmailMessageSender;
import edu.hlju.boler.core.message.UserLogMessageSender;
import edu.hlju.boler.datadictory.UserDataDict;
import edu.hlju.boler.pojo.po.Email;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.po.UserLog;
import edu.hlju.boler.pojo.vo.StateResponse;
import edu.hlju.boler.pojo.vo.ValueResponse;

public abstract class BaseController implements IControllerLog {
    @Resource
    protected ResponseFactory responseFactory;

    @Resource
    protected UserLogMessageSender userLogMessageSender;

    @Resource
    protected EmailMessageSender emailMessageSender;

    protected ValueResponse getResponse(Object value) {
        return responseFactory.getResponse(value);
    }

    protected StateResponse getResponse(UserDataDict userDataDict) {
        return responseFactory.getResponse(userDataDict);
    }

    /**
     * 发送邮件通知
     *
     * @param to 收件人
     * @param from 发件人
     * @param subject 主题
     * @param text 内容
     */
    protected void notifyByEmail(String to, String from, String subject, String text, User user) {
        Email email = new Email();
        email.setFrom(from);
        email.setTo(to);
        email.setSendTime(new Date());
        email.setSubject(subject);
        email.setText(text);
        email.setUser(user);
        emailMessageSender.send(email);
    }

    protected void saveUserLog(HttpServletRequest request, String message) {
        String ip = request.getRemoteAddr();
        User user = (User) request.getSession().getAttribute(UserController.USER_OBJECT);
        UserLog log = new UserLog(ip, user, new Date(), message);
        userLogMessageSender.send(log);
    }

    protected abstract void userLogging(HttpServletRequest request, String message);

}
