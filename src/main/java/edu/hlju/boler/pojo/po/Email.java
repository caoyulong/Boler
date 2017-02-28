package edu.hlju.boler.pojo.po;

import java.util.Date;

import org.springframework.mail.SimpleMailMessage;

public class Email {
    private SimpleMailMessage mail;

    private Integer id;

    private User user;

    public String getFrom() {
        return mail.getFrom();
    }

    public Integer getId() {
        return id;
    }

    public Date getSendTime() {
        return mail.getSentDate();
    }

    public String getSubject() {
        return mail.getSubject();
    }

    public String getText() {
        return mail.getText();
    }

    public String getTo() {
        return mail.getTo()[0];
    }

    public User getUser() {
        return user;
    }

    public void setFrom(String from) {
        mail.setFrom(from);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSendTime(Date sendTime) {
        mail.setSentDate(sendTime);
    }

    public void setSubject(String subject) {
        mail.setSubject(subject);
    }

    public void setText(String text) {
        mail.setText(text);
    }

    public void setTo(String to) {
        mail.setText(to);
    }

    public void setUser(User user) {
        this.user = user;
    }
}
