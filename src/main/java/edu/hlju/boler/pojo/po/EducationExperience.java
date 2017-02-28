package edu.hlju.boler.pojo.po;

import java.util.Date;

public class EducationExperience {
    private Integer id;

    private Date startTime;

    private Date endTime;

    private String school;

    private String degree;

    private String major;

    private String course;

    private OnlineResume resume;

    public String getCourse() {
        return course;
    }

    public String getDegree() {
        return degree;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Integer getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public OnlineResume getOnlineResume() {
        return resume;
    }

    public String getSchool() {
        return school;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setOnlineResume(OnlineResume resume) {
        this.resume = resume;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
