package StrongerII;

import BinaryTree.TreeNode;

public class LA136_LargestSmallerNumberInBST {
    public int largestSmaller(TreeNode root, int target) {
        // assume that root is not null
        int result = Integer.MIN_VALUE;
        while (root != null) {
            if (root.key >= target) {
                root = root.left;   // 如果本身就已经不小于target了，不符合要求直接不看root的右子树
            }
            else {
                result = root.key;
                // 此时的root是有可能满足的第一个解，接下来就往右子树走直到null
                root = root.right;
            }
        }
        return result;
    }
}
