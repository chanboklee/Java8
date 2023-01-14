package com.lee.java8.chapter6;

/**
 * Thread Interrupted
 */
public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            while(true){
                System.out.println("Thread: "+Thread.currentThread().getName());
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    System.out.println("interrupted!");
                    return;
                }
            }
        });
        thread.start();

        System.out.println("Hello: "+Thread.currentThread().getName());
        Thread.sleep(1000L);
        thread.interrupt();

    }
}
