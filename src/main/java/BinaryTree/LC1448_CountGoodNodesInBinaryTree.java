package BinaryTree;

public class LC1448_CountGoodNodesInBinaryTree {
    private int count = 0;

    public int goodNodes(TreeNode root) {
        DFS(root, Integer.MIN_VALUE);
        return count;
    }

    private void DFS(TreeNode root, int curMax) {
        if (root == null) {
            return;
        }
        if (root.key >= curMax) {
            count++;
            curMax = root.key;
        }
        DFS(root.left, curMax);
        DFS(root.right, curMax);
    }
}
