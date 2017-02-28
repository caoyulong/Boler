package edu.hlju.boler.service.system.activemq;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Component;

@Component("messageReceiver")
public class MessageReceiver implements MessageListener {

    @Override
    public void onMessage(Message message) {
        return;
    }

}
