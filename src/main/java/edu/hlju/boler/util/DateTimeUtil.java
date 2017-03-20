package edu.hlju.boler.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    public static final String LOCAL_DATETIME_FORMAT = "yyyy/MM/dd HH:mm:ss";

    private DateTimeUtil() {
    }

    public static String now() {
        SimpleDateFormat sdf = new SimpleDateFormat(LOCAL_DATETIME_FORMAT);
        return sdf.format(new Date());
    }

}
