package StrongerII;

import java.util.*;

public class LA132_DeepCopyGraph {

    static class GraphNode {
        int key;
        List<GraphNode> neighbors;
        public GraphNode(int key) {
            this.key = key;
            neighbors = new ArrayList<GraphNode>();
        }
    }

    public List<GraphNode> deepCopyDFS(List<GraphNode> nodes) {
        Map<GraphNode, GraphNode> oldToNew = new HashMap<>();
        for (GraphNode node : nodes) {
            //  这里是先把node要copy好，放到map里面，进到DFS之后才能继续操作
            oldToNew.put(node, new GraphNode(node.key));
            //  把每个node自带的所有的neighbors都要deep copy到
            DFS(node, oldToNew);
        }
        return new ArrayList<GraphNode>(oldToNew.values());
    }

    private void DFS(GraphNode node, Map<GraphNode, GraphNode> oldToNew) {
        //  之所以用HashMap就是为了去重，免得出现多个copy，比如N1->N3, N4->N3，需要hashmap来保证
        //  只有一个N3' copy被generate出来
        GraphNode copyNode = oldToNew.get(node); // 在进入DFS之前已经copy好且放在map中了
        for (GraphNode nei : node.neighbors) {
            // 如果没有被copy过，那么就要在此被copy并且继续DFS
            if (!oldToNew.containsKey(nei)) {
                oldToNew.put(nei, new GraphNode(nei.key)); // "new"表示真实的在heap上copy出来
                DFS(nei, oldToNew);
            }
            //  这里很重要！不管有没有被generate过，都要加上node -> nei的这条边！虽然node之前deep copy
            //  过了，但是还没有加到当前nei node的neighbors里面！
            copyNode.neighbors.add(oldToNew.get(nei)); // 这里加上的是deep copy过后的nei'，而不是nei
        }
    }

    public List<GraphNode> deepCopyBFS(List<GraphNode> nodes) {
        //  这里没有helper function，直接需要建立result
        List<GraphNode> result = new ArrayList<>();
        Map<GraphNode, GraphNode> oldToNew = new HashMap<>();
        Queue<GraphNode> queue = new ArrayDeque<>();
        for (GraphNode node : nodes) {

        }
    }
}
