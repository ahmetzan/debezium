package com.example.debezium.util;

import java.util.regex.Pattern;

public class CaseUtil {

    public static String toCamelCase(String kebab) {
       return Pattern.compile("_([a-z])")
                .matcher(kebab)
                .replaceAll(mr -> mr.group(1).toUpperCase());
    }
}
