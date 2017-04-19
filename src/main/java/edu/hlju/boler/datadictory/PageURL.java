package edu.hlju.boler.datadictory;

public enum PageURL {
    USER_REGISTER("user/register"),
    EMPLOYEE_INDEX("employee/index"),
    EMPLOY_INDEX("employ/index"),
    EMPLOY_RECRUIT("employ/addRecruit"),
    EMPLOY_ALL_APPS("employ/allApp"),
    EMPLOY_ALL_RECRUITMENTS("employ/allRecruits"),
    EMPLOY_RECRUIT_DETAIL("employ/recruitDetail"),
    ALL_EMAIL_TEMPLATE("employ/allEmailTemp"),
    EMPLOY_ADD_EMAIL_TEMPLATE("employ/addEmailTemp"),
    USER_MODIFY_PASSWORD("user/modifyPassword");

    private String url;

    private PageURL(String path) {
        url = path;
    }

    public String getURL() {
        return url;
    }

}
