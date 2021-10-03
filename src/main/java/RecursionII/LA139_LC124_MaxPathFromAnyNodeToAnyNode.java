package RecursionII;

import BinaryTree.TreeNode;

public class LA139_LC124_MaxPathFromAnyNodeToAnyNode {
    public int maxPathSum(TreeNode root) {
        int[] globalMax = {Integer.MIN_VALUE};
        helper(root, globalMax);
        //  我们还是需要在recursion中返回值的，只是这里调用不用拿到。
        return globalMax[0];
    }

    private int helper(TreeNode root, int[] globalMax) {
        if (root == null) {
            return 0;
        }
        int leftResult = helper(root.left, globalMax);
        int rightResult = helper(root.right, globalMax);
        // 注意负数的会拖累整体，比如如果是[2, -1]要是非要把-1算上去就拖累了root
        leftResult = leftResult < 0 ? 0 : leftResult;
        rightResult = rightResult < 0 ? 0 : rightResult;
        globalMax[0] = Math.max(globalMax[0], leftResult + rightResult + root.key);
        return Math.max(leftResult, rightResult) + root.key;
    }
}
