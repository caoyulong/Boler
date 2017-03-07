package edu.hlju.boler.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {

    public static String now() {
        Date date = new Date();
        Locale locale = new Locale("zh");
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        return dateFormat.format(date);
    }

}
