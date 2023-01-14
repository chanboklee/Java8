package com.lee.java8.chapter6;

/**
 * Thread Join
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(() -> {
            while(true){
                System.out.println("Thread: "+Thread.currentThread().getName());
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    throw new IllegalStateException();
                }
            }
        });
        thread.start();

        System.out.println("Hello: "+Thread.currentThread().getName());
        try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(thread + "is finished");
    }
}
