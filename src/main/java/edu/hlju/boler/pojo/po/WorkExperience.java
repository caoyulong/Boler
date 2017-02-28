package edu.hlju.boler.pojo.po;

import java.util.Date;

public class WorkExperience {
    private Integer id;

    private Date startTime;

    private Date endTime;

    private String corporation;

    private String scale;

    private String department;

    private String job;

    private String detail;

    private OnlineResume resume;

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

    public void setResume(OnlineResume resume) {
        this.resume = resume;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
