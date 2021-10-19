package com.owen.Coding_Practices;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello1");
            }
        };
        //  这里如果改成t.run()就变成了普通函数调用一样，一定会按顺序先执行Hello1然后才会到2、3
        t.start();
        System.out.println("Hello2");
        t.join();   //  假设下面没有Hello3了，且如果t是t.setDaemon(true)的话就会是守护线程，
        // 那么直到Hello3打出来t也不一定会执行
        //  如果不是Daemon thread那么JVM还是会等待t执行完之后才会关闭
        System.out.println("Hello3");
    }
    // t and main thread are concurrent, 所以不一定哪个先后
}
