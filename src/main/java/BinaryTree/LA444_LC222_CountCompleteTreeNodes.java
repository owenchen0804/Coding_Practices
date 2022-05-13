package BinaryTree;

public class LA444_LC222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return 0;
        }
        int left = leftHeight(root);  // 需要用root，解决当前层的问题，这个会在recursion中用到！
        int right = rightHeight(root);
        if (left == right) {
            return (1 << left) - 1; // 注意如果这里相等，说明是完美的二叉树
            //  这里相当于是2^(left) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int leftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }

    private int rightHeight(TreeNode root) {
        int height = 0;
        while (root.right != null) {
            root = root.right;
            height++;
        }
        return height;
    }
}
