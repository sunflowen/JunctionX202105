package com.origincurly.barrierfree.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TransformUtils {

    public static String int2StringFormat(int value, String format) {
        DecimalFormat df = new DecimalFormat("#,##0");
        return String.format(format, df.format(value));
    }

    public static String int2String(int value) {
        DecimalFormat df = new DecimalFormat("#,##0");
        return df.format(value);
    }
    public static Date string2Date(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        return date;
    }

    public static long getNowTimeMil() {
        return Calendar.getInstance().getTimeInMillis();
    }
}