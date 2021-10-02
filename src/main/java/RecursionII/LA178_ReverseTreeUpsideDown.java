package RecursionII;

import BinaryTree.TreeNode;

public class LA178_ReverseTreeUpsideDown {
    public TreeNode reverseUpsideDown(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = reverseUpsideDown(root.left);
        root.left.right = root;
        root.left.left = root.right;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    public TreeNode reverseIterative(TreeNode root) {
        TreeNode prev = null;
        TreeNode prevRight = null;
        while (root != null) {
            TreeNode next = root.left;
            TreeNode right = root.right;
            root.left = prev;
            root.right = prevRight;
            prev = root;
            prevRight = right;
            root = next;
        }
        return prev;
    }
}
