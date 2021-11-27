package StrongerI;

import BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LA58_LC103_ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerFirst(root);
        int layer = 0;
        while (!q.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                if (layer == 0) {
                    TreeNode cur = q.pollFirst();
                    curList.add(cur.key);
                    if (cur.left != null) {
                        q.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        q.offerLast(cur.right);
                    }
                }
                else {
                    TreeNode cur = q.pollLast();
                    curList.add(cur.key);
                    if (cur.right != null) {
                        q.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        q.offerFirst(cur.left);
                    }
                }
            }

            layer = 1 - layer;
            result.add(curList);
        }
        return result;
    }
}
