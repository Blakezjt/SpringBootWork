package com.fdzc.javaeeserver.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String createDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }
}
