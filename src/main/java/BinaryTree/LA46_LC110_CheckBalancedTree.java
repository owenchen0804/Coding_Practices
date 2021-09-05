public class LA46_LC110_CheckBalancedTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftResult = helper(root.left);
        int rightResult = helper(root.right);
        if (leftResult == -1 || rightResult == -1 || Math.abs(leftResult - rightResult) > 1) {
            return -1;
        }
        return Math.max(leftResult, rightResult) + 1;
    }
}