package BinaryTree;

public class LA142_LC543_DiameterOfBinaryTree {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        helper(root);
        return diameter;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        // 自己如果作为转折点，可以是left + right;
        diameter = Math.max(diameter, left + right);
        // 往上传递的时候，则只能取自己单边最大的
        return Math.max(left, right) + 1;
    }
}
