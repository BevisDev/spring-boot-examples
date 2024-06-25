package com.bevis.adminservice.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {
    public static final int MILLIS_PER_SECOND = 1000;
    public static final int MILLIS_PER_MINUTE = 60 * 1000; // 1 minute
    public static final int MILLIS_PER_HOUR = 60 * 60 * 1000; // 1 hour
    public static final int MILLIS_PER_DAY = 24 * 60 * 60 * 1000; // 1 day

    // =========================================================== //
    // ------------------ Stored in the ISO 8601 format
    // =========================================================== //
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_T_HH_MM_SSZ = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String YYYY_MM_DD_T_HH_MM_SS = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String YYYY_MM_DD_T_HH_MM_SS_SSSZ = "yyyy-MM-dd'T'HH:mm:ss:SSSZ";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String MM_DD_YYYY = "MM/dd/yyyy";

    // =========================================================== //
    // ------------------ Date Time format
    // =========================================================== //
    public static final String DD_MMM_YYYY_HH_MM_SS = "dd-MMM-yyyy HH:mm:ss";
    public static final String DD_MMM_YYYY_DASH = "dd-MMM-yyyy";
    public static final String DD_MM_YY_SLASHED = "dd/MM/yy";
    public static final String MM_YYYY_SLASHED = "MM/yyyy";
    public static final String MMM_YYYY_SLASHED = "MMM/yyyy";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String HH_MM = "HH:mm";

    public static Date convertStringToDate(String str, String pattern) throws ParseException {
        DateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.parse(str);
    }

    public static String convertDateToString(Date date, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
}
