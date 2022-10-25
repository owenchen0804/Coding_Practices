package Heap;

import java.util.PriorityQueue;

public class LC1167_MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        //  Consider 3 sticks = [a1, a2, a3];
        //  先合并a1, a2, 得到[a1 + a2, a3]; cost = a1 + a2
        //  再合并，得到[a1 + a2 + a3]; cost = a1 + a2 + a3
        //  总体的cost = 2a1 + 2a2 + a3
        //  很明显，每次要加上最小的2个，因为算到最后的cost前面的加的次数最多，当然越小越好
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.offer(stick);
        }
        int result = 0;
        while (pq.size() > 1) {
            //  到只剩size == 1的时候跳出循环
            int stick1 = pq.poll();
            int stick2 = pq.poll();
            int merged = stick1 + stick2;
            result += merged;
            pq.offer(merged);
        }
        //  出来后pq的size只有1了
        return result;
    }
}
