package edu.hlju.boler.service.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.hlju.boler.dao.IEmailDao;
import edu.hlju.boler.pojo.po.Email;
import edu.hlju.boler.service.interfaces.system.IEmailService;

@Service("emailService")
public class EmailService implements IEmailService {
    @Resource
    private IEmailDao emailDao;

    @Override
    public void save(Email email) {
        // TODO Auto-generated method stub

    }

    @Override
    public void send(Email email) {
        // TODO Auto-generated method stub

    }

}
