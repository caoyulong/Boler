package edu.hlju.boler.core.message.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import edu.hlju.boler.core.interfaces.IMessageHandler;
import edu.hlju.boler.core.interfaces.IUserLogService;
import edu.hlju.boler.core.message.UserLogMessageListener;
import edu.hlju.boler.pojo.po.UserLog;
import edu.hlju.boler.util.DateTimeUtil;

@Component
public class UserLogMessageHandler implements IMessageHandler {
    private static final Logger logger = LoggerFactory.getLogger(UserLogMessageListener.class);

    @Resource(name = "userLogService")
    private IUserLogService userLogService;

    @Override
    public void handle(Object message) {
        if (message instanceof UserLog) {
            userLogService.add((UserLog) message);
            logger.info("[{}] {}", DateTimeUtil.now(), "Saved a received UserLog.");
        }
    }

}
