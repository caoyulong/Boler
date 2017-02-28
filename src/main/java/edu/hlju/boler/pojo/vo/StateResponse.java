package edu.hlju.boler.pojo.vo;

import edu.hlju.boler.datadictory.UserDataDict;

public class StateResponse extends BaseResponse {
    private int code;
    private String message;

    public StateResponse(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public StateResponse(UserDataDict dataDict) {
        super();
        code = dataDict.getCode();
        message = dataDict.getMessage();
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
