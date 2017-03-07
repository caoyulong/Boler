package edu.hlju.boler.pojo.po;

import java.util.Date;

public class ProjectExperience {
    private Integer id;

    private String name;

    private String teamScale;

    private String role;

    private String projectIntroduction;

    private Date startTime;

    private Date endTime;

    private String detail;

    private OnlineResume resume;

    private Date createTime;

    private Date modifyTime;

    public Date getCreateTime() {
        return createTime;
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public String getName() {
        return name;
    }

    public String getProjectIntroduction() {
        return projectIntroduction;
    }

    public OnlineResume getResume() {
        return resume;
    }

    public String getRole() {
        return role;
    }

    public Date getStartTime() {
        return startTime;
    }

    public String getTeamScale() {
        return teamScale;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectIntroduction(String projectIntroduction) {
        this.projectIntroduction = projectIntroduction;
    }

    public void setResume(OnlineResume resume) {
        this.resume = resume;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setTeamScale(String teamScale) {
        this.teamScale = teamScale;
    }
}
