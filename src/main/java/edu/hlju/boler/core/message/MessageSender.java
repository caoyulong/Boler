package edu.hlju.boler.core.message;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import edu.hlju.boler.core.interfaces.IMessageSender;
import edu.hlju.boler.util.DateTimeUtil;

@Component
public class MessageSender implements IMessageSender {
    private static final Logger logger = LoggerFactory.getLogger(MessageSender.class);

    @Resource(name = "jmsQueueTemplate")
    private JmsTemplate jmsQueueTemplate;

    @Override
    public void send(Object obj) {
        jmsQueueTemplate.convertAndSend(obj);
        logger.info("[{}] {}", DateTimeUtil.now(), "Message sent.");
    }

}
