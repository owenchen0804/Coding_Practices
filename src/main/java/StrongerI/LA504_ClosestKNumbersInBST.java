package StrongerI;

import BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class LA504_ClosestKNumbersInBST {
    public int[] closestKValue(TreeNode root, double target, int k) {
        // iterative的解决问题，所以In-order的遍历也是iterative的并且就是递增的顺序
        // 对于BST来说，sliding window没办法是slow & fast，所以就用queue来代替
        // queue前面出，后面进，只有后面离target更近的时候前面才会出，否则就满足条件返回了。
        Queue<TreeNode> q = new ArrayDeque<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        // stack是为了模仿计算机做的in-order iterative遍历
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            }
            else {
                curr = stack.pollFirst();
                if (q.size() < k) {
                    // 如果sliding window还不够大，就一直进queue
                    q.offer(curr);
                }
                else if (q.size() == k) {
                    if (Math.abs(q.peek().key - target) > Math.abs(target - curr.key)) {
                        q.poll();
                        q.offer(curr);
                    }
                    else {
                        break;
                    }
                }
                curr = curr.right;
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = q.poll().key;
        }
        return result;
    }
}
