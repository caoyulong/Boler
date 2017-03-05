package edu.hlju.boler.core.message;

import javax.annotation.Resource;

import org.springframework.jms.core.JmsTemplate;

import edu.hlju.boler.core.interfaces.IMessageSender;

public class MessageSender implements IMessageSender {
    @Resource(name = "jmsQueueTemplate")
    private JmsTemplate jmsQueueTemplate;

    @Override
    public void send(Object obj) {
        jmsQueueTemplate.convertAndSend(obj);
    }

}
