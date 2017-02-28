package edu.hlju.boler.pojo.po;

import java.util.Date;

public class Email {
    private Integer id;

    private User user;

    private String from;

    private String to;

    private String subject;

    private Date sendTime;

    private String text;

    public String getFrom() {
        return from;
    }

    public Integer getId() {
        return id;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public String getTo() {
        return to;
    }

    public User getUser() {
        return user;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
