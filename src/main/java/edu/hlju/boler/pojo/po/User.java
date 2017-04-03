package edu.hlju.boler.pojo.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class User {
    private Integer id;

    @NotNull
    private Role role;

    @Email
    private String email;

    private String password;

    private PersonInfo personInfo;

    private Date createTime;

    private Date modifyTime;

    public User() {
        role = new Role();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public String getPassword() {
        return password;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public Role getRole() {
        return role;
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

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", role=" + role + ", email=" + email + ", password=" + password + ", personInfo="
                + personInfo + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
    }

}
