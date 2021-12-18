package RecursionIII;

import BinaryTree.TreeNode;

public class LA639_MaxPathSumFromLeafToLeaf {
    public int max(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode root, int[] max) {
        if (root == null) return 0;
        int left = helper(root.left, max);
        int right = helper(root.right, max);

        if (root.left == null) {
            return right + root.key;
        }
        if (root.right == null) {
            return left + root.key;
        }
        // left & right都有值，就要做取舍
        // 且此时的root有资格参加max[]的比拼
        max[0] = Math.max(max[0], left + right + root.key);
        // 但是往上传递的还是只能是较大的一边
        return Math.max(left, right) + root.key;
    }
}
