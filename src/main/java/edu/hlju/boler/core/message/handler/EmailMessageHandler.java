package edu.hlju.boler.core.message.handler;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import edu.hlju.boler.core.interfaces.IEmailService;
import edu.hlju.boler.core.interfaces.IMessageHandler;
import edu.hlju.boler.pojo.po.Email;

@Component
public class EmailMessageHandler implements IMessageHandler {
    @Resource(name = "emailService")
    private IEmailService emailService;

    @Override
    public void handle(Object message) {
        if (message instanceof Email) {
            emailService.send((Email) message);
        }
    }

}
