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
        //  Map存的不仅仅是所有的copied node，还有原来node与node之间的连接关系！

        List<GraphNode> result = new ArrayList<>();
        Map<GraphNode, GraphNode> map = new HashMap<>();
        Queue<GraphNode> queue = new ArrayDeque<>();
        for (GraphNode node : nodes) {
            queue.offer(node);
            map.put(node, new GraphNode(node.key));
            //  这里只存了input提供的这些nodes，在queue里面还会存其他的所有neighbor nodes
            result.add(map.get(node));  // result存的都是copy出来的node'
        }
        //  到for循环结束其实copied nodes都完成了，但是我们还要把neighbors的信息copy出来
        //  所以需要Map的帮助去重
        while (!queue.isEmpty()) {
            //  Expand and Generate
            GraphNode old = queue.poll();
            for (GraphNode nei : old.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei, new GraphNode(nei.key));
                    queue.offer(nei);
                }
                //  不管有没有见过nei，都要把对应的邻居关系加进来
                map.get(old).neighbors.add(map.get(nei));
                //  注意map.get(old)拿到的就是old', 这个copied node在while前面就被copy过了
                //  后面neighbors里面添加到list里面的也是nei'，也就是map.get(nei)
                //  假设之前见过nei那么直接可以map.get()，如果没见过，在if()里面也会添加
            }
        }
        return result;
    }
}
