package BinaryTree;

public class LA51_LC701_InsertBST {
    public TreeNode insertBST(TreeNode root, int key) {
        TreeNode newNode = new TreeNode(key);
        if (root == null) {
            return newNode;
        }
        if (root.key > key) {
            root.left = insertBST(root.left, key);
        }
        else {
            root.right = insertBST(root.right, key);
        }
        return root;
    }
    //  Iterative
    public TreeNode insert(TreeNode root, int key) {
        TreeNode newNode = new TreeNode(key);
        if (root == null) {
            return newNode;
        }
        TreeNode curr = root;
        while (curr.key != key) {
            if (curr.key > key) {
                if (curr.left == null) {
                    curr.left = newNode;
                    break;
                }
                else {
                    curr = curr.left;
                }
            }
            else {
                if (curr.right == null) {
                    curr.right = newNode;
                    break;
                }
                else {
                    curr = curr.right;
                }
            }
        }
        return root;
    }
}