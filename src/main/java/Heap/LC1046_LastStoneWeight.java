package Heap;

import java.util.PriorityQueue;

public class LC1046_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() >= 2) {
            int x = queue.poll();
            int y = queue.poll();
            if (x > y) {
                queue.offer(x - y);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
