package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LA43_LC94_InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        //  同样是模拟recursion中的stack，和preOrder不同，顺序是左-根-右
        //  所以要一直左走到不能走了才会pop出左，然后自己，再去右边
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            //  注意在curr就是整棵树的root的时候打印出来之后stack一定是空的，但是此时curr指向了root不是叶子所以也不会结束循环
            if (curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            }
            //  一直往左走到叶子，然后pop出来
            else {
                curr = stack.pollFirst();
                result.add(curr.key);
                curr = curr.right;
            }
        }
        return result;
    }
}