package com.lee.java8.chapter5;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeApi {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println("instant = " + instant); // 기준시 UTC, GMT

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("zoneId = " + zoneId);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println("zonedDateTime = " + zonedDateTime);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        LocalDateTime birtyDay = LocalDateTime.of(1991, Month.SEPTEMBER, 8, 0, 0);

        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2023, Month.SEPTEMBER, 8);
        Period period = Period.between(today, thisYearBirthday);
        System.out.println("days = " + period.getDays());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("dateTimeFormatter = " + dateTimeFormatter);

        LocalDate parse = LocalDate.parse("08/09/1991", dateTimeFormatter);
        System.out.println("parse = " + parse);


    }
}
