package Probability;

import java.util.Collections;
import java.util.PriorityQueue;

public class LA113_MedianTracker {
    private PriorityQueue<Integer> smallerHalf;
    private PriorityQueue<Integer> largerHalf;
    public LA113_MedianTracker() {
        // add new fields and complete the constructor if necessary.
        largerHalf = new PriorityQueue<>();
        smallerHalf = new PriorityQueue<Integer>(11, Collections.reverseOrder());
        // 我们只需关注smallerHalf的最大值和largerHalf的最小值，所以smallerHalf需要反序存
    }

    //  我们自己规定smallerHalf.size()要么和largerHalf相等，要么多一个


    public void read(int value) {
        // write your implementation here.
        if (smallerHalf.isEmpty() || value <= smallerHalf.peek()) {
            smallerHalf.offer(value);
        }
        else {
            largerHalf.offer(value);
        }
        // 还没完，要保证size按照我们规定的那样可能需要调整
        if (smallerHalf.size() >= largerHalf.size() + 2) {
            largerHalf.offer(smallerHalf.poll()); // 把smallerHalf的最大值promote到largerHalf
        }
        else if (largerHalf.size() > smallerHalf.size()) {
            smallerHalf.offer(largerHalf.poll());
        }
        // 都不满足的话就什么都不做
    }

    public Double median() {
        // write your implementation here.
        if (smallerHalf.isEmpty() && largerHalf.isEmpty()) {
            return null;
        }
        if (smallerHalf.size() - largerHalf.size() == 1) {
            return (double) smallerHalf.peek();
        }
        else {
            return (smallerHalf.peek() + largerHalf.peek()) / 2.0;
        }
    }
}
