package RecursionIII;

import BinaryTree.TreeNode;

public class LA523_LC114_FlattenBinaryTreeToLL {
    public void flatten(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        helper(root, prev);
        return;
    }

    private void helper(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        if (prev[0] != null) {
            prev[0].right = root;
        }
        root.left = null;
        prev[0] = root;
        helper(leftNode, prev);
        helper(rightNode, prev);
    }
}
