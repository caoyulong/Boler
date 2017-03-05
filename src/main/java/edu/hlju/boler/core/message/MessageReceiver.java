package edu.hlju.boler.core.message;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Component;

import edu.hlju.boler.core.interfaces.IEmailService;
import edu.hlju.boler.core.interfaces.IUserLogService;
import edu.hlju.boler.pojo.po.Email;
import edu.hlju.boler.pojo.po.UserLog;

@Component("messageReceiver")
public class MessageReceiver implements MessageListener {
    @Resource(name = "emailService")
    private IEmailService emailService;

    @Resource(name = "userLogService")
    private IUserLogService userLogService;

    @Override
    public void onMessage(Message message) {
        if (message instanceof Email) {
            emailService.send((Email) message);
        } else if (message instanceof UserLog) {
            userLogService.add((UserLog) message);
        }
    }

}
