package edu.hlju.boler.datadictory;

public enum UserDataDict {
    REGISTER_SUCCEED(100, "Register succeed."),
    REGISTER_FAILED(101, "Register failed."),
    LOGIN_SUCCEED(102, "Login succeed."),
    LOGIN_FAILED(103, "Login failed."),
    LOGOUT_SUCCEED(104, "Logout succeed."),
    LOGOUT_FAILED(105, "Logout failed."),
    MODIFY_PASSWD_SUCCEED(106, "Modify password succeed."),
    MODIFY_PASSWD_FAILED(107, "Modify password failed."),
    SAVE_PERSON_INFO_SCCUCEED(108, "Save person info succeed."),
    SAVE_PERSON_INFO_FAILED(109, "Save person info failed."),
    OPERATIING_SUCCEED(200, "Operating succeed."),
    OPERATIING_FAILED(201, "Operating failed."),
    NOT_LOGINED(203, "Not logined.");

    private int code;

    private String message;

    private UserDataDict(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
