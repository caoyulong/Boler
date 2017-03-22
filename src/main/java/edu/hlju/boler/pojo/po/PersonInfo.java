package edu.hlju.boler.pojo.po;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

public class PersonInfo {
    private Integer id;

    private String realname;

    private String sex;

    private Date birthday;

    @Length(min = 11, max = 11)
    private String cellphone;

    private String profile;

    private String speciality;

    private String avatar;

    private String address;

    private Date createTime;

    private Date modifyTime;

    public String getAddress() {
        return address;
    }

    public String getAvatar() {
        return avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getCellphone() {
        return cellphone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Integer getId() {
        return id;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public String getProfile() {
        return profile;
    }

    public String getRealname() {
        return realname;
    }

    public String getSex() {
        return sex;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
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

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "PersonInfo [id=" + id + ", realname=" + realname + ", sex=" + sex + ", birthday=" + birthday
                + ", cellphone=" + cellphone + ", profile=" + profile + ", speciality=" + speciality + ", avatar="
                + avatar + ", address=" + address + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
    }
}
