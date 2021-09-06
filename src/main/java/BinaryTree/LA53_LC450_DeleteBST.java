package BinaryTree;

public class LA53_LC450_DeleteBST {
    public TreeNode deleteBST(TreeNode root, int key) {
        //  if (root == null || root.key == key) {
        //  以上是错的，如果找到需要删除的root节点，还要在删除之后维持BST的特性，所以需要分情况讨论！
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = deleteBST(root.left, key);
            return root;
        }
        else if (key < root.key) {
            root.right = deleteBST(root.right, key);
            return root;
        }
        // 到这里说明已经找到对应的root.key == key了
        if (root.left == null) {
            return root.right;
        }
        else if (root.right == null) {
            return root.left;
        }
        else if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }
        else {//    root左右都有，且右子树的左子树不为null
            //  思路是从右子树一直往左走，也就是比root大的最小值，继承皇位当新的root
            TreeNode smallestLarger = findSmallest(root);
            smallestLarger.left = root.left;
            smallestLarger.right = root.right;
            return smallestLarger;
        }
    }

    private TreeNode findSmallest(TreeNode root) {
        TreeNode prev = root;
        TreeNode curr = prev.left;
        while (curr.left != null) {
            prev = curr;
            curr = curr.left;
        }
        //  curr.left == null 跳出循环，说明curr就是最左子树的节点
        prev.left = curr.right;
        return curr;
    }
}