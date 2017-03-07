package edu.hlju.boler.pojo.po;

import java.util.Date;

import org.springframework.mail.SimpleMailMessage;

public class Email {
    private SimpleMailMessage mail;

    private Integer id;

    private User user;

    private Date createTime;

    private Date modifyTime;

    public Date getCreateTime() {
        return createTime;
    }

    public String getFrom() {
        return mail.getFrom();
    }

    public Integer getId() {
        return id;
    }

    public Date getModifyTime() {
        return modifyTime;
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

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setFrom(String from) {
        mail.setFrom(from);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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

    @Override
    public String toString() {
        return "Email [mail=" + mail + ", id=" + id + ", user=" + user + ", createTime=" + createTime + ", modifyTime="
                + modifyTime + "]";
    }
}
