package edu.hlju.boler.datadictory;

public enum RegExDataDict {
    EMAIL_REGEX("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$"),
    TEL_REGEX("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$"),
    ID_REGEX("^\\d{15}|\\d{18}$"),
    DATE_REGEX("^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}$");

    private String message;

    private RegExDataDict(String msg) {
        message = msg;
    }

    public String getMessage() {
        return message;
    }

}
