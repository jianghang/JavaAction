package com.hangjiang.java8.time;

import java.time.*;

/**
 * Created by jianghang on 2017/8/31.
 */
public class TimeDemo {

    public static void main(String[] args){
//        LocalDateDemo();
//        LocalTimeDemo();
//        LocalDateTimeDemo();

        InstantDemo();
    }

    private static void InstantDemo() {
        Duration threeMinutes = Duration.ofMinutes(3);
        System.out.println(threeMinutes.getSeconds());

        Duration duration = Duration.between(LocalTime.of(14,50),LocalTime.of(14,54,12));
        System.out.println(duration.getSeconds());

        Period day = Period.of(2017,9,1);
        System.out.println(day.getDays());
    }

    private static void LocalDateTimeDemo() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);

        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localTime);
    }

    private static void LocalTimeDemo() {
        LocalTime time = LocalTime.of(13,45,12);
        System.out.println(LocalTime.parse("13:56:20"));
        System.out.println(time);

        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
    }

    private static void LocalDateDemo() {
        LocalDate localDate = LocalDate.of(2017,9,1);
        System.out.println(LocalDate.parse("2017-09-01"));
        System.out.println(localDate.toString());

        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int day = localDate.getDayOfMonth();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int len = localDate.lengthOfMonth();
        boolean leap = localDate.isLeapYear();

        System.out.println(year + " : " + month + " : " + day + " : " + dayOfWeek + " : " + len + " : " + leap);

        LocalDate today = LocalDate.now();
        System.out.println(today.toString());
    }
}
