package edu.hlju.boler.pojo.po;

import java.util.Date;

public class OnlineResume {
    private Integer id;

    private String name;

    private PersonInfomation personInfo;

    private User user;

    private Date createTime;

    private Date modifyTime;

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
        return modifyTime;
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
        modifyTime = updateTime;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OnlineResume [id=" + id + ", name=" + name + ", personInfo=" + personInfo + ", user=" + user
                + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
    }
}
