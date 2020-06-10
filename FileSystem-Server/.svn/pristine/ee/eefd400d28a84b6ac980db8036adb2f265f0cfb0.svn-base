package com.free4lab.filesystem.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Idan on 2017/7/20.
 */
public class TimeUtil {

    public static Date getCurrentTime() {
        return new Date(System.currentTimeMillis());
    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    //Date 格式化成string
    public static String ConverToString(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return date==null?null:df.format(date);
    }

}
