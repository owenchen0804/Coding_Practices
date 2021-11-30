package StrongerI;

import BinaryTree.TreeNodeP;

class Result {
    public TreeNodeP node;
    public int count;
    public Result(TreeNodeP n, int c) {
        node = n;
        count = c;
    }
}

public class LA127_LCA_II {
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        if (one == null || two == null) {
            return null;
        }
        if (one == two) {
            return one;
        }
        Result resultOne = getDepth(one);
        Result resultTwo = getDepth(two);
        if (resultOne.node != resultTwo.node) {
            return null;
        }
        int depthOne = resultOne.count;
        int depthTwo = resultTwo.count;

        // int depthOne = getDepth2(node1);
        // int depthTwo = getDepth2(node2);
        // if (node1[0] != node2[0]) {
        //  return null;
        // }

        if ( depthOne >= depthTwo) {
            return getLCA(one, two, depthOne - depthTwo);
        }
        else {
            return getLCA(two, one, depthTwo - depthOne);
        }
    }

    private TreeNodeP getLCA(TreeNodeP lowerNode, TreeNodeP higherNode, int height) {
        while (height > 0) {
            lowerNode = lowerNode.parent;
            height--;
        }
        while (lowerNode != higherNode) {
            lowerNode = lowerNode.parent;
            higherNode = higherNode.parent;
        }
        return lowerNode;
    }

    private Result getDepth(TreeNodeP root) {
        //  Depth of root is 1
        int count = 1;
        while (root.parent != null) {
            root = root.parent;
            count++;
        }
        return new Result(root, count);
    }

    //  这种办法适用于面试时，开一个size为1的数组
    private int getDepth2(TreeNodeP[] node) {
        int count = 1;
        while (node[0].parent != null) {
            node[0] = node[0].parent;
        }
        return count;
    }
}
