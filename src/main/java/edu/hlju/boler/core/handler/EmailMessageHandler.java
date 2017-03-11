package edu.hlju.boler.core.handler;

import javax.annotation.Resource;
import javax.jms.Message;

import edu.hlju.boler.core.interfaces.IEmailService;
import edu.hlju.boler.core.interfaces.IMessageHandler;
import edu.hlju.boler.pojo.po.Email;

public class EmailMessageHandler implements IMessageHandler {
    @Resource(name = "emailService")
    private IEmailService emailService;

    @Override
    public void handle(Message message) {
        if (message instanceof Email) {
            emailService.send((Email) message);
        }
    }

}
