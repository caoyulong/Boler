package edu.hlju.boler.pojo.po;

import java.util.Date;

public class WorkExp {
    private Integer id;

    private Date startTime;

    private Date endTime;

    private String corporation;

    private String scale;

    private String department;

    private String job;

    private String detail;

    private OnlineResume resume;

    private Date createTime;

    private Date modifyTime;

    public String getCorporation() {
        return corporation;
    }

    public String getDepartment() {
        return department;
    }

    public String getDetail() {
        return detail;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Integer getId() {
        return id;
    }

    public String getJob() {
        return job;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public OnlineResume getResume() {
        return resume;
    }

    public String getScale() {
        return scale;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public void setResume(OnlineResume resume) {
        this.resume = resume;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "WorkExp [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", corporation="
                + corporation + ", scale=" + scale + ", department=" + department + ", job=" + job + ", detail="
                + detail + ", resume=" + resume + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
    }

}
