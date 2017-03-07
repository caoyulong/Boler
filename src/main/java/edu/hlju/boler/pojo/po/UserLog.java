package edu.hlju.boler.pojo.po;

import java.util.Date;

public class UserLog {
    private Integer id;

    private User user;

    private String ipAddress;

    private Date recordTime;

    public UserLog() {
    }

    public UserLog(String ipAddress, User user, String message) {
    }

    public Integer getId() {
        return id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public User getUser() {
        return user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
