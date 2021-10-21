package com.owen.Coding_Practices;

public class VolatileTest {
    //  public static boolean flag = false;
    public volatile static boolean flag = false;
    // 这就是原子性，这一个变量对它的读or写操作"看起来"像是先对它上锁，再读/写，然后再放锁

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (!flag) {
                // System.out.println("The thread is running...");
                // 这就是data race，因为flag的值不确定，main thread在写，而newThread在读

            }
            System.out.println("The thread is finished...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread newThread = new Thread(new MyRunnable());
        newThread.start();
        Thread.sleep(1000);
        flag = true;
        System.out.println("Main thread is finished...");
    }
}