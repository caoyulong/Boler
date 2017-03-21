package edu.hlju.boler.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import edu.hlju.boler.common.ResponseFactory;
import edu.hlju.boler.core.message.MessageSender;
import edu.hlju.boler.datadictory.UserDataDict;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.pojo.po.UserLog;
import edu.hlju.boler.pojo.vo.ListResponse;
import edu.hlju.boler.pojo.vo.MapResponse;
import edu.hlju.boler.pojo.vo.StateResponse;
import edu.hlju.boler.pojo.vo.ValueResponse;

public abstract class BaseService {
    @Resource
    private ResponseFactory responseFactory;

    @Resource
    private MessageSender messageSender;

    protected ListResponse getResponse(List<Object> list) {
        return responseFactory.getResponse(list);
    }

    protected MapResponse getResponse(Map<Object, Object> map) {
        return responseFactory.getResponse(map);
    }

    protected ValueResponse getResponse(Object value) {
        return responseFactory.getResponse(value);
    }

    protected StateResponse getResponse(UserDataDict userDataDict) {
        return responseFactory.getResponse(userDataDict);
    }

    protected UserLog getUserLog(HttpServletRequest request, String message) {
        String ip = request.getRemoteAddr();
        User user = (User) request.getSession().getAttribute(UserService.USER_OBJECT);
        return new UserLog(ip, user, message);
    }

    protected void saveUserLog(HttpServletRequest request, String message) {
        this.sendMessage(this.getUserLog(request, message));
    }

    protected void sendMessage(Object obj) {
        messageSender.send(obj);
    }

}
