package StrongerI;

import BinaryTree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LA129_LC1676_LCAIV {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node);
        }
        return helper(root, set);
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> set) {
        if (root == null) {
            return root;
        }
        if (set.contains(root)) {
            return root;
        }
        TreeNode left = helper(root.left, set);
        TreeNode right = helper(root.right, set);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
