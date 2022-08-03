package BinaryTreeEnhanced;

import BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC437_Better {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return count;
        }
        Map<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(0, 1);
        helper(root, 0, targetSum, hashmap);
        return count;
    }
    private void helper(TreeNode root, int preSum, int target, Map<Integer, Integer> hashmap) {

        int sum = preSum + root.key;
        if (hashmap.containsKey(sum - target)) {
            count += hashmap.get(sum - target);
            // count++;
        }

        hashmap.put(sum, hashmap.getOrDefault(sum, 0) + 1);

        if (root.left != null) {
            helper(root.left, sum, target, hashmap);
        }
        if (root.right != null) {
            helper(root.right, sum, target, hashmap);
        }
        hashmap.put(sum, hashmap.get(sum) - 1);

    }

    public static void main(String[] args) {
        LC437_Better testCase = new LC437_Better();
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        System.out.println(testCase.pathSum(t1, 10));
    }

}
