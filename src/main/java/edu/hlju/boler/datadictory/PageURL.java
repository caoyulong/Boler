package edu.hlju.boler.datadictory;

public enum PageURL {
    USER_REGISTER("user/register"),
    EMPLOY_INDEX("employ/index"),
    EMPLOY_RECRUIT("employ/recruit"),
    EMPLOYEE_INDEX("employee/index"),
    EMPLOY_ALL_APPS("employ/allApp");

    private String url;

    private PageURL(String path) {
        url = path;
    }

    public String getURL() {
        return url;
    }
}
