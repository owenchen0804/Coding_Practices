package StrongerII;

import java.util.*;

public class LC133_DeepCopyGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

        public Node cloneGraph(Node node) {
            if (node == null) {
                return node;
            }
            Map<Node, Node> visited = new HashMap<>();
            visited.put(node, new Node(node.val));
            DFS(node, visited);
            return visited.get(node);
        }

        private void DFS(Node node, Map<Node, Node> visited) {
            // 没有base case，因为不需要，加完了所有nodes自然退出
            Node copy = visited.get(node);
            for (Node nei : node.neighbors) {
                if (!visited.containsKey(nei)) {
                    visited.put(nei, new Node(nei.val));
                    // 对于新加入的nei node都需要再做DFS，如果不是新加入
                    // 的话不需要做DFS了，因此DFS要放在if()里面
                    DFS(nei, visited);
                }
                copy.neighbors.add(visited.get(nei));
                // 但是对于每一个copy node而言，不管nei是否被visit过，都是要加到neighbors里面
                // 所以这里应该放在if()外面，表示哪怕之前visit过也还是要加进去
                // 比如A的neighbor是B，对于A要把B加到neighbors里；同样对于B来说
                // 虽然A已经在visited map里了，还是要加上neighbors
            }
        }



    public Node cloneGraph2(Node node) {
        if (node == null) return node;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        Map<Node, Node> visited = new HashMap<>();
        visited.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            for (Node nei : n.neighbors) {
                if (!visited.containsKey(nei)) {
                    visited.put(nei, new Node(nei.val));
                    queue.offer(nei);
                }
                visited.get(n).neighbors.add(visited.get(nei));
            }
        }
        return visited.get(node);
    }
}
