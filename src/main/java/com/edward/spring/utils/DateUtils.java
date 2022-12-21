package com.edward.spring.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public final class DateUtils {

    public static final String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";
    public static final String ISO_8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    private DateUtils() {}

    /**
     * Minus few days from now with starting time. And then convert to millisecond.
     * 主要是以"天"為單位作減法，所以時分秒就不計算，也沒有一天中間作減法然後算到過去的中間，
     * 以下算法來減去days，就不包含執行的當天
     *
     * @return millisecond
     */
    public static long minusDaysFromNowToMillisec(int days) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now().minusDays(days).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);
        return zonedDateTime.toInstant().toEpochMilli();
    }

    /**
     * Plus few days from now with starting time. And then convert to millisecond.
     * 主要是以"天"為單位作加法，所以時分秒就不計算，也沒有一天中間作加法然後算到未來的中間，
     * 以下算法來加去days，包含執行的當天，當天也算一天，往後加
     *
     * 最後確定不需要考慮時分秒，ZonedDateTime zonedDateTime = ZonedDateTime.now().plusDays(days);
     *
     * @param days days
     * @return millisecond
     */
    public static long plusDaysFromNowToMillisec(int days) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now().plusDays(days).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);
        return zonedDateTime.toInstant().toEpochMilli();
    }

    public static Date parseStringToDate(String dateTime, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateTime);
    }

    public static Date addMinute(Date date, int minutes) {
        long milliseconds = date.getTime() + (minutes * 60 * 1000L);
        return new Date(Math.round(milliseconds));
    }

    public static Date addHour(Date date, int hours) {
        long milliseconds = date.getTime() + (hours * 60 * 60 * 1000L);
        return new Date(Math.round(milliseconds));
    }

    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    public static Date subtractionHour(Date date, int hours) {
        long milliseconds = date.getTime() - (hours * 60 * 60 * 1000L);
        return new Date(Math.round(milliseconds));
    }

    public static Date subtractionDays(Date date, int days) {
        long milliseconds = date.getTime() - (days * 24 * 60 * 60 * 1000L);
        return new Date(Math.round(milliseconds));
    }
}
