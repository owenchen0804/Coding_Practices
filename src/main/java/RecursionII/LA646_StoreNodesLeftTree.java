package RecursionII;

public class LA646_StoreNodesLeftTree {
    static class TreeNodeLeft{
        int key;
        TreeNodeLeft left;
        TreeNodeLeft right;
        int numNodesLeft;
        public TreeNodeLeft(int key) {
            this.key = key;
        }
    }

    public int numNodes(TreeNodeLeft root) {
        if (root == null) {
            return 0;
        }
        int left = numNodes(root.left);
        int right = numNodes(root.right);
        root.numNodesLeft =  left;
        return left + right + 1;
    }
}
