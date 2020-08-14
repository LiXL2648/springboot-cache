package com.li.springboot.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtile {

    public static Date getDate(String DateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(DateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
