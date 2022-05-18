package BinaryTree;

public class LC331_VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
// It is better to consider the problems from the relation of edges and nodes:
// 1. For a full binary tree, # of node = # of edges + 1, thus if 在等式左边+ 1，then the # of edges = the # of nodes;
// 2. For a node, it consumes one edge and produces 2 new edges(if not null)

        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
    //  这道题不是真的给出来一个pre-order的tree，而是让你判断，实际上不需要在乎是什么order，只是要看这个是不是一个valid binary tree
    //  因为只有一种iteration是无法确认到底是不是一定是pre/in/post的，它可能三种情况都满足，当然也满足是一颗preorder的
}
