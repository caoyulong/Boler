package edu.hlju.boler.pojo.po;

import java.util.Date;

public class Application {
    private Integer id;

    private User employ;

    private User employee;

    private Byte state;

    private Date createTime;

    private Date modifyTime;

    public Date getCreateTime() {
        return createTime;
    }

    public User getEmploy() {
        return employ;
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

    public Byte getState() {
        return state;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setEmploy(User employ) {
        this.employ = employ;
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

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Application [id=" + id + ", employ=" + employ + ", employee=" + employee + ", createTime=" + createTime
                + ", modifyTime=" + modifyTime + ", state=" + state + "]";
    }
}
