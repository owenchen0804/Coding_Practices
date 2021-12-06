package com.owen.Coding_Practices;

import BinaryTree.TreeNode;

public class BSTTest {
    public int closest(TreeNode root, int target) {
        // Write your solution here
        int result = Integer.MIN_VALUE + 1;
        return helper(root, target, result);
    }

    private int helper(TreeNode root, int target, int result) {
        if (root == null) {
            return result;
        }
        if (Math.abs(target - result) > Math.abs(root.key - target)) {
            result = root.key;
        }
        if (root.key < target) {
            return helper(root.right, target, result);
        }
        else {
            return helper(root.left, target, result);
        }
    }

    public static void main(String[] args) {
        BSTTest test = new BSTTest();
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        System.out.println(test.closest(n1, 0));
    }
}
