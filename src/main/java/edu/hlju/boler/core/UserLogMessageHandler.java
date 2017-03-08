package edu.hlju.boler.core;

import javax.annotation.Resource;
import javax.jms.Message;

import edu.hlju.boler.core.interfaces.IMessageHandler;
import edu.hlju.boler.core.interfaces.IUserLogService;
import edu.hlju.boler.pojo.po.UserLog;

public class UserLogMessageHandler implements IMessageHandler {
    @Resource(name = "userLogService")
    private IUserLogService userLogService;

    @Override
    public void handle(Message message) {
        if (message instanceof UserLog) {
            userLogService.add((UserLog) message);
        }
    }

}
