package edu.hlju.boler.pojo.po;

import java.util.Date;

public class Application {
    private Integer id;

    private Date createTime;

    private User employ;

    private User employee;

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
}
