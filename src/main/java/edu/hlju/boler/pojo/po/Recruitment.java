package edu.hlju.boler.pojo.po;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Recruitment {
    private Integer id;

    private String corporation;

    private String jobName;

    private JobType jobType;

    private Integer lowSalary;

    private Integer highSalary;

    private String address;

    private String industry;

    private String jobDetail;

    private String requirement;

    private User employ;

    private Byte state;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expireDate;

    private Date createTime;

    private Date modifyTime;

    public String getAddress() {
        return address;
    }

    public String getCorporation() {
        return corporation;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public User getEmploy() {
        return employ;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getExpireDate() {
        return expireDate;
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

    public JobType getJobType() {
        return jobType;
    }

    public Integer getLowSalary() {
        return lowSalary;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public String getRequirement() {
        return requirement;
    }

    public Byte getState() {
        return state;
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

    public void setEmploy(User employ) {
        this.employ = employ;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
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

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public void setLowSalary(Integer lowSalary) {
        this.lowSalary = lowSalary;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Recruitment [id=" + id + ", corporation=" + corporation + ", jobName=" + jobName + ", jobType="
                + jobType + ", lowSalary=" + lowSalary + ", highSalary=" + highSalary + ", address=" + address
                + ", industry=" + industry + ", jobDetail=" + jobDetail + ", requirement=" + requirement + ", employ="
                + employ + ", state=" + state + ", expireDate=" + expireDate + ", createTime=" + createTime
                + ", modifyTime=" + modifyTime + "]";
    }

}
