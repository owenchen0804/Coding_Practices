package RecursionIII;

import BinaryTree.TreeNode;

public class LA140_MaxPathSumBinaryTreeIII {
    public int maxPathSum(TreeNode root) {
        // Write your solution here
        int[] globalMax = new int[] {Integer.MIN_VALUE};
        int preSum = 0;
        helper(root, preSum, globalMax);
        return globalMax[0];
    }

    private void helper(TreeNode root, int preSum, int[] globalMax) {
        if (root == null) {
            return;
        }
        if (preSum < 0) {
            preSum = root.key;
        }
        else {
            preSum += root.key;
        }
        globalMax[0] = Math.max(globalMax[0], preSum);
        helper(root.left, preSum, globalMax);
        helper(root.right, preSum, globalMax);
    }
}
