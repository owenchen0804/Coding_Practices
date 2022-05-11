package BinaryTree;

public class LC226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode one = invertTree(root.left);
        TreeNode two = invertTree(root.right);
        root.left = two;
        root.right = one;
        return root;
    }
}
