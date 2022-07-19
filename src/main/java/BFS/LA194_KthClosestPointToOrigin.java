package BFS;

import java.util.*;

public class LA194_KthClosestPointToOrigin {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                long d1 = getDistance(o1, a, b, c);
                long d2 = getDistance(o2, a, b, c);
                if (d1 == d2) {
                    return 0;
                }
                return d1 < d2 ? -1 : 1;
            }
        });

        Set<List<Integer>> visited = new HashSet<>();
        List<Integer> origin = Arrays.asList(0, 0, 0);
        minHeap.offer(origin);
        visited.add(origin);
        List<Integer> curr = new ArrayList<>();

        while (k > 0) {
            curr = minHeap.poll();
            List<Integer> n = Arrays.asList(curr.get(0) + 1, curr.get(1), curr.get(2));
            if (n.get(0) < a.length && visited.add(n)) {
                minHeap.offer(n);
            }
            n = Arrays.asList(curr.get(0), curr.get(1) + 1, curr.get(2));
            if (n.get(1) < b.length && visited.add(n)) {
                minHeap.offer(n);
            }
            n = Arrays.asList(curr.get(0), curr.get(1), curr.get(2) + 1);
            if (n.get(2) < c.length && visited.add(n)) {
                minHeap.offer(n);
            }
            k--;
            // 如果k = 1的话只poll出一次，curr = {0, 0, 0}对应到a[]b[]c[]的坐标就是第一组数，最小
            // 此时如果还有循环的话已经把[1,0,0], [0,1,0],[0,0,1]放到minHeap了
            // 再poll一次的话出来的就是第二小的，看对应是哪一个，所以curr此时对应的坐标就是答案
        }
        curr.set(0, a[curr.get(0)]);
        curr.set(1, b[curr.get(1)]);
        curr.set(2, c[curr.get(2)]);
        return curr;
    }

    private long getDistance(List<Integer> point, int[] a, int[] b, int[] c) {
        long dis = 0;
        dis += a[point.get(0)] * a[point.get(0)];
        dis += b[point.get(1)] * b[point.get(1)];
        dis += c[point.get(2)] * c[point.get(2)];
        return dis;
    }
}
