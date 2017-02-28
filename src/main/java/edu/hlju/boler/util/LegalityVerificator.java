package edu.hlju.boler.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LegalityVerificator {

    public static boolean isLegal(String data, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

}
