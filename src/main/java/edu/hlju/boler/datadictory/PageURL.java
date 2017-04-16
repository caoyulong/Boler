package edu.hlju.boler.datadictory;

public enum PageURL {
    USER_REGISTER("user/register"),
    EMPLOYEE_INDEX("employee/index"),
    EMPLOY_INDEX("employ/index"),
    EMPLOY_RECRUIT("employ/recruit"),
    EMPLOY_ALL_APPS("employ/allApp"),
    EMPLOY_ALL_RECRUITMENTS("employ/allRecruits"),
    EMPLOY_RECRUIT_DETAIL("employ/recruitDetail");

    private String url;

    private PageURL(String path) {
        url = path;
    }

    public String getURL() {
        return url;
    }
}
