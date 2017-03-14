package edu.hlju.boler.pojo.po;

public class JobType {
    private Integer id;
    private String type;

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "JobType [id=" + id + ", type=" + type + "]";
    }

}
