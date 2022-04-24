package DIYStructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) {
        Q q = new Q(20);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            threads.add(new Thread(new Producer(q)));
        }
        for (int i = 0; i < 40; i++) {
            threads.add(new Thread(new Consumer2(q)));
        }
        for (Thread t : threads) {
            t.start();
        }
    }
}

class Producer implements Runnable {
    Q q;
    public Producer(Q q) {
        super();
        this.q = q;
    }
    @Override
    public void run() { // 多一个线程，就多一个放入0的操作
        q.put(0);
    }
}

class Consumer2 implements Runnable {
    Q q;
    public Consumer2(Q q) {
        super();
        this.q = q;
    }
    @Override
    public void run() {
        System.out.println(q.take());
    }
}

class Q {   // blocking queue
    private Queue<Integer> q;
    private final int limit;
    public Q(int limit) {
        this.limit = limit;
        this.q = new ArrayDeque<>();
    }

    public synchronized void put(Integer ele) {
        while (q.size() == limit) {
            try {
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        if (q.size() == 0) {
            notifyAll();
        }
        q.offer(ele);
    }

    public synchronized Integer take() {
        while (q.size() == 0) {
            try {
                wait(); // wait() releases the Object lock();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (q.size() == limit) {
            notifyAll();
        }
        return q.poll();
    }
}

