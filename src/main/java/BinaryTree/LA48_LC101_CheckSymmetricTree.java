package BinaryTree;

public class LA48_LC101_CheckSymmetricTree {
    public boolean checkSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        }
        if (one == null || two == null || one.key != two.key) {
            return false;
        }
        return helper(one.left, two.left) && helper(one.right, two.right)
                || helper(one.left, two.right) && helper(one.right, two.left);
    }
}