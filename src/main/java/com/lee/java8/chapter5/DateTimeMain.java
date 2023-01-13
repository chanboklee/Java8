package com.lee.java8.chapter5;

import java.util.Date;

/**
 * java.util.Date 클래스는 mutable 하기 때문에 thread safe하지 않다.
 * 클래스 이름이 명확하지 않다. Date인데 시간까지 다룬다.
 */
public class DateTimeMain {
    public static void main(String[] args) throws InterruptedException {

        Date date = new Date();
        long time = date.getTime();
        System.out.println("date = " + date);
        System.out.println("time = " + time);

        Thread.sleep(1000 * 3);
        Date date1 = new Date();
        long time1 = date1.getTime();
        System.out.println("date1 = " + date1);
        System.out.println("time1 = " + time1);

        date1.setTime(time);
        System.out.println("date1 = " + date1);

    }

}
