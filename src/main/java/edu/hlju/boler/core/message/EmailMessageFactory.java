package edu.hlju.boler.core.message;

import org.springframework.context.annotation.Bean;

import edu.hlju.boler.core.handler.EmailMessageHandler;
import edu.hlju.boler.core.interfaces.IMessageHandler;
import edu.hlju.boler.core.interfaces.IMessageHandlerFactory;

public class EmailMessageFactory implements IMessageHandlerFactory {

    @Bean
    @Override
    public IMessageHandler getMessageHandler() {
        return new EmailMessageHandler();
    }

}
