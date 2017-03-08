package edu.hlju.boler.core.interfaces;

import javax.jms.Message;

@FunctionalInterface
public interface IMessageHandler {

    void handle(Message message);

}
