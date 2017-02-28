package edu.hlju.boler.pojo.po;

import java.util.Date;

public class OnlineResume {
    private Integer id;

    private String name;

    private Date createTime;

    private PersonInfomation personInfo;

    private User user;

    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PersonInfomation getPersonInfo() {
        return personInfo;
    }

    public Date getUpdateTime() {
        return updateTime;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonInfo(PersonInfomation personInfo) {
        this.personInfo = personInfo;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
