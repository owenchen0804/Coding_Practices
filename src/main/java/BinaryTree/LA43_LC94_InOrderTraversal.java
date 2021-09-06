package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LA43_LC94_InOrderTraversal {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //  模拟一个call stack的工作，所以需要new一个stack出来
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            }
            else {  // 左边走到底到null了，可以打印最左边的节点了
                curr = stack.pollFirst();
                result.add(curr.key);
                curr = curr.right;
            }
        }
        return result;
    }
}