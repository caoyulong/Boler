package edu.hlju.boler.core.message.handler;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import edu.hlju.boler.core.interfaces.IMessageHandler;
import edu.hlju.boler.core.interfaces.IUserLogService;
import edu.hlju.boler.pojo.po.UserLog;

@Component
public class UserLogMessageHandler implements IMessageHandler {
    @Resource(name = "userLogService")
    private IUserLogService userLogService;

    @Override
    public void handle(Object message) {
        if (message instanceof UserLog) {
            userLogService.add((UserLog) message);
        }
    }

}
