package StrongerII;

import java.util.ArrayList;
import java.util.List;

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
        
    }
}
