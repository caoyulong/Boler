package edu.hlju.boler.datadictory;

public enum UserDataDict {
    REGISTER_SUCCEED(100, "Register succeed."),
    REGISTER_FAILED(101, "Register failed."),
    LOGIN_SUCCEED(102, "Login succeed."),
    LOGIN_FAILED(103, "Login failed."),
    LOGOUT_SUCCEED(104, "Logout succeed."),
    LOGOUT_FAILED(105, "Logout failed.");

    private int code;
    private String message;

    private UserDataDict(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private UserDataDict(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
