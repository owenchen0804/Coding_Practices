package Heap;

import java.util.PriorityQueue;

public class LC703_KthLargestElementInAStream {
    //  要online的随时return第k大的元素，首先想到的就是
    //  maintain一个大小为k的minHeap

    // minHeap和k都是final的，一旦赋予了就不能更改
    final PriorityQueue<Integer> minHeap;
    final int k;

    public LC703_KthLargestElementInAStream(int k, int[] nums) {
        //  这个应该是只调用一次，所以k也只会赋值一次, nums也是一次性全部进minHeap
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            //  这里不是直接调用已有的offer() api
            //  而是调用add()，这样会用到
            //  minHeap.offer(num);
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        }
        else if (minHeap.peek() < val) {
            //  minHeap.poll();
            //  顺序无所谓，更好想的是先进去，再出来一个
            minHeap.offer(val);
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
