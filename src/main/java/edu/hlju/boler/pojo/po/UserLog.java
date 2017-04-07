package edu.hlju.boler.pojo.po;

import java.io.Serializable;
import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Data;

public class UserLog implements Serializable {
    private static final long serialVersionUID = 2195719684454925652L;

    private Integer id;

    private User user;

    private String ipAddress;

    private Date recordTime;

    private String message;

    public UserLog() {
    }

    public UserLog(String ipAddress, User user, Date recordTime, String message) {
        this.ipAddress = ipAddress;
        this.user = user;
        this.recordTime = recordTime;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getMessage() {
        return message;
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

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserLog [id=" + id + ", user=" + user + ", ipAddress=" + ipAddress + ", recordTime=" + recordTime
                + ", message=" + message + "]";
    }

}
