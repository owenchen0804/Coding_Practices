package com.owen.Coding_Practices;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello1");
            }
        };
        t.start();
        System.out.println("Hello2");
        t.join();
        System.out.println("Hello3");
    }
    // t and main thread are concurrent, 所以不一定哪个先后
}
