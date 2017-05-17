package edu.hlju.boler.core;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import edu.hlju.boler.core.interfaces.IEmailService;
import edu.hlju.boler.dao.IEmailDao;
import edu.hlju.boler.pojo.po.Email;
import edu.hlju.boler.pojo.po.User;
import edu.hlju.boler.service.interfaces.IUserService;
import edu.hlju.boler.util.DateTimeUtil;

@Service("emailService")
public class EmailService implements IEmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Resource
    private IEmailDao emailDao;

    @Resource
    private JavaMailSenderImpl emailSender;

    @Resource(name = "userService")
    private IUserService userService;

    /**
     * 将简单对象的Email转换成可以发送的Email
     * @param email 简单对象Email
     * @return SimpleMailMessage, 可以发送的Email
     */
    private SimpleMailMessage sendable(Email email) {
        SimpleMailMessage ssm = new SimpleMailMessage();
        ssm.setFrom(email.getFrom());
        ssm.setTo(email.getTo());
        ssm.setSubject(email.getSubject());
        ssm.setSentDate(email.getSendTime());
        ssm.setText(email.getText());
        ssm.setSentDate(email.getSendTime());
        return ssm;
    }

    @Override
    public void save(Email email) {
        try {
            emailDao.insert(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(Email email) {
        this.save(email);  // 发送前保存记录
        User user = email.getUser();
        emailSender.setUsername(user.getEmail());
        emailSender.setPassword(user.getPassword());
        emailSender.send(this.sendable(email));
        logger.info("[{}] {}", DateTimeUtil.now(), "Sent a Email.");
    }

}
