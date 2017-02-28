package edu.hlju.boler.pojo.po;

import java.util.Date;

public class User {
    private Integer id;

    private String email;

    private String password;

    private Date createTime;

    private PersonInfomation personInfo;

    public Date getCreateTime() {
        return createTime;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public PersonInfomation getPersonInfo() {
        return personInfo;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPersonInfo(PersonInfomation personInfo) {
        this.personInfo = personInfo;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", password=" + password + ", createTime=" + createTime
                + ", personInfo=" + personInfo + "]";
    }

}
