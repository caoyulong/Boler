package edu.hlju.boler.pojo.po;

import java.util.Date;

public class UserLog {
    private Integer id;

    private Date recordTime;

    private String ipAddress;

    private Integer user;

    private Integer permission;

    public UserLog() {
    }

    public UserLog(String ipAddress, Integer user, Integer permission) {
        super();
        this.ipAddress = ipAddress;
        this.user = user;
        this.permission = permission;
    }

    public UserLog(String ipAddress, Integer user, String message) {
    }

    public Integer getId() {
        return id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Integer getPermission() {
        return permission;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public Integer getUser() {
        return user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public void setUser(Integer user) {
        this.user = user;
    }
}
