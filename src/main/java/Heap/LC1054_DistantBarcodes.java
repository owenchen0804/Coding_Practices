package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC1054_DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        //  这道题和767的不同点就在于这是guarantee有解的，那么最多的那个数字肯定不会超过一半
        //  可以采用PriorityQueue的办法每次选取2个最大的放到result，然后更新map，再放回到PQ中
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> { return Integer.compare(b[1], a[1]);});
        //  把所有的barcode和对应的freq都放到pq，可以拿到最大的
        for (int key : map.keySet()) {
            maxHeap.offer(new int[]{key, map.get(key)});
        }
        //  int[] result = new int[barcodes.length];
        //  由于map已经存好了barcodes的所有信息，所以可以直接在Input中overwrite来输出
        int index = 0;
        while (maxHeap.size() >= 2) {
            int[] first = maxHeap.poll();
            int[] second = maxHeap.poll();
            barcodes[index++] = first[0];
            barcodes[index++] = second[0];
            map.put(first[0], first[1] - 1);
            map.put(second[0], second[1] - 1);
            //  注意一定要判断一下是否对应的value为0了，到0就不要再往maxHeap放了！!
            if (first[1] - 1 > 0) {
                maxHeap.offer(new int[]{first[0], first[1] - 1});
            }
            if (second[1] - 1 > 0) {
                maxHeap.offer(new int[]{second[0], second[1] - 1});
            }

        }
        if (!maxHeap.isEmpty()) {
            barcodes[index] = maxHeap.poll()[0];
        }
        return barcodes;
    }
}
