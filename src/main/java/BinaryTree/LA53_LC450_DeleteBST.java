package BinaryTree;

public class LA53_LC450_DeleteBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.key > key) {
            root.left = deleteNode(root.left, key); //  往左边走，但是要用root.left来连接删除后的左子树
            //  并且别忘了一定要return root;
            return root;
        }
        if (root.key < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        //  能走到这里，说明root.val == key了，需要删除的TreeNode找到了
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        //  到这里说明两边子树都不为空，再比较一下右孩子有没有左孩子，没有的话可以直接把右孩子提上来，
        //  这样右孩子的右孩子也随之跟着上来，但是连接关系不会变
        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }
        //  到这里进入到最复杂的情况，左右孩子都有；思路是从右孩子出发一直左走到最左边，把它拎上来到当前的位置
        //  根据BST性质，这个是root的右子树里最小的，也能拉到root上，比所有左子树的值都大
        //  拎走后，它的右子树挂在它的parent，也就是倒数第二左的node的左边
        TreeNode smallest = findSmallest(root.right);
        smallest.left = root.left;
        smallest.right = root.right;
        return smallest;
    }

    private TreeNode findSmallest(TreeNode curr) {
        //  这个method不仅找到最左边的node，还捎带手的把善后连接工作做好了
        TreeNode prev = curr;
        curr = curr.left;   //  前面论证了一定有左孩子，所以此时的curr一定不为null
        while (curr.left != null) {
            prev = curr;
            curr = curr.left;
        }
        //  走到这里说明curr.left == null 也就是curr就是最左的TreeNode
        prev.left = curr.right;
        return curr;
    }
}