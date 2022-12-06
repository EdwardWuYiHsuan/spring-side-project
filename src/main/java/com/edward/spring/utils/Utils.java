package com.edward.spring.utils;


import org.apache.commons.text.RandomStringGenerator;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Utils {

    private static final String EMAIL_PATTERN_REX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String REGEX_IDENTITY_NUMBER = "^[A-Z]\\d{9}$";

    private Utils() {}

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
     * @param days
     * @return millisecond
     */
    public static long plusDaysFromNowToMillisec(int days) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now().plusDays(days).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);
        return zonedDateTime.toInstant().toEpochMilli();
    }

    /**
     * Verify Email Address is valid or not.
     *
     * @param mailAddr	Email address, e.g. abc123@apple.com
     * @return result
     */
    public static boolean isValidEmailAddress(String mailAddr) {
        if (null == mailAddr || mailAddr.length() == 0) {
            return false;
        }

        Pattern pattern = Pattern.compile(EMAIL_PATTERN_REX);
        Matcher matcher = pattern.matcher(mailAddr);
        return matcher.matches();
    }

    public static boolean isValidBooleanValue(String value) {
        if (null == value || value.length() == 0) {
            return false;
        }

        return value.equalsIgnoreCase(Boolean.TRUE.toString()) || value.equalsIgnoreCase(Boolean.FALSE.toString());
    }

    public static Optional<Integer> isValidIntegerValue(String value) {
        try {
            return Optional.of(Integer.parseInt(value));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static Optional<Long> isValidLongValue(String value) {
        try {
            return Optional.of(Long.parseLong(value));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidIdentityNumber(String identityNumber) {
        if (null == identityNumber || identityNumber.length() == 0) {
            return false;
        }

        try {
            Pattern pattern = Pattern.compile(Utils.REGEX_IDENTITY_NUMBER);
            Matcher matcher = pattern.matcher(identityNumber.trim());
            return matcher.matches();
        } catch (Exception e ) {
            return false;
        }
    }

    /**
     * 產生指定長度的亂數數字字串
     */
    public static String generateRandomDigital(int length) {
        char[][] pairs = {{'0', '9'}};
        org.apache.commons.text.RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange(pairs).build();
        return generator.generate(length);
    }

    /**
     * 確認是否為本機(localhost)的IP
     *
     * localhost name resolution is handled within DNS itself
     * > 127.0.0.1    localhost
     * > ::1          localhost
     *
     * Bug:某次使用此方法確認，需求是只能讓本機呼叫，非本機吐出unauthorized，但明明是本機呼叫卻收到unauthorized？
     * 原因是因為Java獲取的IP為0:0:0:0:0:0:0:1，0:0:0:0:0:0:0:1是ipv6的表現形式，對應ipv4來說相當於127.0.0.1，就是本機，
     * 但為什麼從request.getRemoteAddr()獲取得值為0:0:0:0:0:0:0:1，照理說應該是127.0.0.1才對，
     * 發生只在於 應用程式啟動 和 客戶端發送 在同一台電腦，經查證，
     * 原來是/etc/hosts這個東西在作怪(window是C:\Windows\System32\drivers\etc\hosts這個文件)，
     * 只需要註解文件中 # ::1 localhost 這一行就可以解決問題
     *
     */
    public static boolean isLocalhost(HttpServletRequest request) {
        final String ip;
        if (request.getHeader("api-gateway-source-ip") != null && !request.getHeader("api-gateway-source-ip").matches("") &&
                !request.getHeader("api-gateway-source-ip").matches("null")) {  //From API gateway.
            ip = request.getHeader("api-gateway-source-ip").split(",")[0];
        } else if (request.getHeader("x-forwarded-for") != null && !request.getHeader("x-forwarded-for").matches("") &&
                !request.getHeader("x-forwarded-for").matches("null")) {  //From WAF or load balancer.
            ip = request.getHeader("x-forwarded-for").split(",")[0];
        } else {
            ip = request.getRemoteAddr();
        }

        return ip.matches("127.0.0.1") || ip.matches("::1");
    }

    public static String getIpAddress(HttpServletRequest request){
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (String strIp : ips) {
                if (!"unknown".equalsIgnoreCase(strIp)) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }
}
