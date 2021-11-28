package StrongerI;

import BinaryTree.TreeNode;

public class LA135_LC270_ClosestBSTValue {
    public int closestValue(TreeNode root, double target) {
        int result = root.key;
        while (root != null) {
            if (root.key == target) {
                return root.key;
            }
            if (Math.abs(root.key - target) < Math.abs(result - target)) {
                result = root.key;
            }
            if (root.key < target) {
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return result;
    }
}
