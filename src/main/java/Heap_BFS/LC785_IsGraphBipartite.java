package Heap_BFS;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LC785_IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        //  visited里面的key指的是每一个node,在这道题里用的整数表示；对应的value就是它应该所在的group
        Map<Integer, Integer> visited = new HashMap<>();
        for (int index = 0; index < graph.length; index++) {
            if (!BFS(index, graph, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean BFS(int index, int[][] graph, Map<Integer, Integer> visited) {
        if (visited.containsKey(index)) {
            return true;
        }
        //  每一次BFS都是新建的queue，把可能是isolated notes放进来，然后看看它们neighbors能否分组成功
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(index);
        visited.put(index, 0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int curGroup = visited.get(curr);
            int neiGroup = curGroup == 0 ? 1 : 0;
            for (int i : graph[curr]) {
                if (!visited.containsKey(i)) {
                    visited.put(i, neiGroup);
                    queue.offer(i);
                }
                else if (visited.get(i) != neiGroup) {
                    return false;
                }
            }
        }
        return true;
    }
}
