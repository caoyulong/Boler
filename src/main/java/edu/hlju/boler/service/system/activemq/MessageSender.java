package edu.hlju.boler.service.system.activemq;

import javax.annotation.Resource;

import org.springframework.jms.core.JmsTemplate;

import edu.hlju.boler.service.interfaces.system.activemq.IMessageSender;

public class MessageSender implements IMessageSender {
    @Resource(name = "jmsQueueTemplate")
    private JmsTemplate jmsQueueTemplate;

    @Override
    public void send(Object obj) {
        jmsQueueTemplate.convertAndSend(obj);
    }

}
