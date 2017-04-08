package edu.hlju.boler.core.message.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import edu.hlju.boler.core.interfaces.IEmailService;
import edu.hlju.boler.core.interfaces.IMessageHandler;
import edu.hlju.boler.core.message.UserLogMessageListener;
import edu.hlju.boler.pojo.po.Email;
import edu.hlju.boler.util.DateTimeUtil;

@Component
public class EmailMessageHandler implements IMessageHandler {
    private static final Logger logger = LoggerFactory.getLogger(UserLogMessageListener.class);

    @Resource(name = "emailService")
    private IEmailService emailService;

    @Override
    public void handle(Object message) {
        if (message instanceof Email) {
            emailService.send((Email) message);
            logger.info("[{}] {}", DateTimeUtil.now(), "Sent a email.");
        }
    }

}
