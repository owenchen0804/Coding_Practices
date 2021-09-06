package BinaryTree;//  TC: O(n) 每个node过一遍
//  SC: O(height)

public class LA54_LC98_ValidateBST {
    public boolean validBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 以下如果root.left == null就会NPE
        //  if (root.left.key >= root.key || root.key >= root.right.key) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.key <= min || root.key >= max) {
            return false;
        }
        //  既把自己(root.key)当做取值范围传了下去，同时也要往上传自己左右分叉分别对应的结果
        return helper(root.left, min, root.key) && helper(root.right, root.key, max);
    }
}