package BinaryTree;

public class LA347_SecondLargestInBST {
    public int secondLargest(TreeNode root) {
        // Write your solution here
        int result = Integer.MIN_VALUE;
        if (root == null) {
            return result;
        }
        if (root.right == null) {
            return root.left == null ? result : findMax(root.left);
        }
        TreeNode prev = root;
        TreeNode curr = prev.right;
        while (curr.right != null) {
            prev = curr;
            curr = curr.right;
        } //  跳出循环时，curr是最右节点，prev是倒数第二个
        if (curr.left == null) {
            return prev.key;
        }
        return findMax(curr.left);
    }

    private int findMax(TreeNode root) {
        if (root.right == null) {
            return root.key;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.key;
    }
}
