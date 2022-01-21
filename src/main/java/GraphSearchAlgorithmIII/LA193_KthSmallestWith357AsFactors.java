package GraphSearchAlgorithmIII;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LA193_KthSmallestWith357AsFactors {
    public long kth(int k) {
        // Assumption: k >= 1
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        minHeap.offer(3 * 5 * 7L);
        visited.add(3 * 5 * 7L);    // 已经放了一个，还需要放k-1次
        while (k > 1) {
            Long curr = minHeap.poll();
            if (visited.add(3 * curr)) {    // 装的进去的话会返回true
                minHeap.offer(3 * curr);
            }
            if (visited.add(5 * curr)) {
                minHeap.offer(5 * curr);
            }
            if (visited.add(7 * curr)) {
                minHeap.offer(7 * curr);
            }
            k--;
        }
        return minHeap.poll();
    }
}
