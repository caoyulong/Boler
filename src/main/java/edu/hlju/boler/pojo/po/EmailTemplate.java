package edu.hlju.boler.pojo.po;

import java.util.Date;

public class EmailTemplate {
    private Integer id;

    private User user;

    private String subject;

    private String text;

    private Date createTime;

    private Date modifyTime;

    public Date getCreateTime() {
        return createTime;
    }

    public Integer getId() {
        return id;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "EmailTemplate [id=" + id + ", user=" + user + ", subject=" + subject + ", text=" + text
                + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
    }

}
