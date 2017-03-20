package edu.hlju.boler.core.message;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import edu.hlju.boler.core.interfaces.IMessageHandler;
import edu.hlju.boler.util.DateTimeUtil;

@Component("messageReceiver")
public class MessageReceiver implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

    @Resource
    private IMessageHandler emailMessageHandler;

    @Resource
    private IMessageHandler userLogMessageHandler;

    @Override
    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        logger.info("[{}] {}", DateTimeUtil.now(), "Receive a message.");
        emailMessageHandler.handle(objectMessage);
        userLogMessageHandler.handle(objectMessage);
    }

}
