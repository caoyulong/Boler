package edu.hlju.boler.pojo.po;

import java.util.Date;

public class Application {
    private Integer id;

    private User employee;

    private Recruitment recruitment;

    private Byte state;

    private Date createTime;

    private Date modifyTime;

    public Date getCreateTime() {
        return createTime;
    }

    public User getEmployee() {
        return employee;
    }

    public Integer getId() {
        return id;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public Recruitment getRecruitment() {
        return recruitment;
    }

    public Byte getState() {
        return state;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public void setRecruitment(Recruitment recruitment) {
        this.recruitment = recruitment;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Application [id=" + id + ", employee=" + employee + ", recruitment=" + recruitment + ", state=" + state
                + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
    }
}
