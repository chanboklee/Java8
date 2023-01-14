package com.lee.java8.chapter6;

/**
 * Thread 사용법
 */
public class ThreadMain {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("Thread: "+Thread.currentThread().getName());
        });
        thread.start();

        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello: "+Thread.currentThread().getName());
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Thread: "+Thread.currentThread().getName());
        }
    }
}
