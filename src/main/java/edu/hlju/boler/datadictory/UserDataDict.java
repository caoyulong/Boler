package edu.hlju.boler.datadictory;

public enum UserDataDict {
    REGISTER_SUCCESS(100, "注册成功"), REGISTER_FAILED(200, "注册失败"), LOGIN_SUCCESS(101, "登录成功"), LOGIN_FAILED(201, "登录失败");

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
