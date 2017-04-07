package edu.hlju.boler.core.message;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import edu.hlju.boler.core.interfaces.IMessageHandler;
import edu.hlju.boler.util.DateTimeUtil;

@Component
public class UserLogMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(UserLogMessageListener.class);

    @Resource
    private IMessageHandler userLogMessageHandler;

    @Override
    public void onMessage(Message message) {
        try {
            Object msg = ((ObjectMessage) message).getObject();
            logger.info("[{}] {}", DateTimeUtil.now(), "Received a UserLog message.");
            userLogMessageHandler.handle(msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
