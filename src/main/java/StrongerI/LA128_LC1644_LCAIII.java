package StrongerI;

import BinaryTree.TreeNode;

public class LA128_LC1644_LCAIII {
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {
        // write your solution here
        TreeNode result = helper(root, one, two);
        if (result == one) {
            return helper(one, two, two) == null ? null : result;
        }
        if (result == two) {
            return helper(two, one, one) == null ? null : result;
        }
        return result;
    }

    private TreeNode helper(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null || root == one || root == two) {
            return root;
        }
        TreeNode left = helper(root.left, one, two);
        TreeNode right = helper(root.right, one, two);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
