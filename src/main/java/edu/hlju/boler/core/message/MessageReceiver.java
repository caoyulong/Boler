package edu.hlju.boler.core.message;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import edu.hlju.boler.core.EmailMessageHandler;
import edu.hlju.boler.core.UserLogMessageHandler;
import edu.hlju.boler.util.DateTimeUtil;

@Component("messageReceiver")
public class MessageReceiver implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

    @Override
    public void onMessage(Message message) {
        logger.info(DateTimeUtil.now(), "Receive a message.");
        new EmailMessageHandler().handle(message);
        new UserLogMessageHandler().handle(message);
    }

}
