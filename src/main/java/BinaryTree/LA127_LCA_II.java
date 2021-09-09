package BinaryTree;

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
        if ( depthOne >= depthTwo) {
            // getLCA(one, two, depthOne - depthTwo);
        }
        else {
            // getLCA(two, one, depthTwo - depthOne);
        }
        return one;
    }

    //private TreeNodeP getLCA(TreeNodeP lowerNode, TreeNodeP higherNode, int height) {

   // }

    private Result getDepth(TreeNodeP root) {
        int count = 1;
        while (root.parent != null) {
            root = root.parent;
            count++;
        }
        return new Result(root, count);
    }
}
