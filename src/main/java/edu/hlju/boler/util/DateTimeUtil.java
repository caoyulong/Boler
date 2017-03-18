package edu.hlju.boler.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    public static final String LOCAL_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private DateTimeUtil() {
    }

    public static String now() {
        SimpleDateFormat sdf = new SimpleDateFormat(LOCAL_DATETIME_FORMAT);  //2016-9-46 15:30:49
        return sdf.format(new Date());  //将Date实例转换成String
    }

}
