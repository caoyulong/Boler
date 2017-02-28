package edu.hlju.boler.pojo.po;

import java.util.Date;

public class Recruitment {
    private Integer id;

    private String corporation;

    private String jobName;

    private Integer lowSalary;

    private Integer highSalary;

    private String address;

    private String industry;

    private String jobDetail;

    private String requirement;

    private User user;

    private Date createTime;

    public String getAddress() {
        return address;
    }

    public String getCorporation() {
        return corporation;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Integer getHighSalary() {
        return highSalary;
    }

    public Integer getId() {
        return id;
    }

    public String getIndustry() {
        return industry;
    }

    public String getJobDetail() {
        return jobDetail;
    }

    public String getJobName() {
        return jobName;
    }

    public Integer getLowSalary() {
        return lowSalary;
    }

    public String getRequirement() {
        return requirement;
    }

    public User getUser() {
        return user;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setHighSalary(Integer highSalary) {
        this.highSalary = highSalary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setJobDetail(String jobDetail) {
        this.jobDetail = jobDetail;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setLowSalary(Integer lowSalary) {
        this.lowSalary = lowSalary;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
