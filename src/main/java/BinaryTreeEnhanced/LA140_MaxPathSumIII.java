package BinaryTreeEnhanced;

import BinaryTree.TreeNode;

public class LA140_MaxPathSumIII {
    public int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] globalMax = {Integer.MIN_VALUE};
        helper(root, globalMax);
        return globalMax[0];
    }

    private int helper(TreeNode root, int[] globalMax) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, globalMax);
        int right = helper(root.right, globalMax);
        int sum = Math.max(Math.max(left, right), 0) + root.key;
        globalMax[0] = Math.max(sum, globalMax[0]);
        return sum;
    }
}
