public class LA52_LC700_SearchBST {
    public TreeNode searchBST(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.key == target) {
            return root;
        }
        //  以上两种情况应该合并写！
        return root.key < target ? searchBST(root.right, target) : searchBST(root.left, target);
    }

    public TreeNode search(TreeNode root, int key) {
        TreeNode curr = root;
        while (curr != null || curr.key != key) {
            curr = curr.key > key ? curr.left : curr.right;
        }
        return curr;
    }
}