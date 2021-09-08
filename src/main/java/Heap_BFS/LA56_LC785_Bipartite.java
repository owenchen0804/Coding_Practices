package Heap_BFS;

import java.util.*;

class GraphNode{
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
        this.key = key;
        neighbors = new ArrayList<GraphNode>();
    }
}

public class LA56_LC785_Bipartite {
    public boolean bipartite(List<GraphNode> graph) {
        Map<GraphNode, Integer> visited = new HashMap<>();
        // graph可能是好几个island构成的，彼此不相干，所以必须每一个GraphNode都要做BFS
        for (GraphNode node : graph) {
            if (!BFS(node, visited)) {
                return false;
            }
        }
        return true;
    }

    //  算法思路: 通过BFS的方法来遍历每一个node，但如何去重呢？需要用HashMap记录group number以及是否visited过了

    private boolean BFS(GraphNode node, Map<GraphNode, Integer> visited) {
        if (visited.containsKey(node)) {    // 如果node被traverse过就不用再做了
            return true;
        }
        Queue<GraphNode> q = new ArrayDeque<>();
        q.offer(node);
        visited.put(node, 0);
        while (!q.isEmpty()) {  //从第一个node开始，每一个邻居都要进入queue"过堂"判断group value
            GraphNode curr = q.poll();
            int curGroup = visited.get(curr);  // group assigned for current node
            int neiGroup = curGroup == 0 ? 1 : 0;   // assign group for all neighbors of current node
            for (GraphNode nei : curr.neighbors) {
                if (!visited.containsKey(nei)) {
                    q.offer(nei);   //  没有访问过的要进入queue中
                    visited.put(nei, neiGroup);
                }
                else if (visited.get(nei) != neiGroup) {
                    // 如果neighbor node被visited过，且对应的group number不是neiGroup，说明产生了冲突
                    return false;
                }
                //  如果所有neighbor nodes都被traverse过了，且都match上了group number，就啥也不做
            }
        }
        return true;
    }
}