package com.owen.Coding_Practices;

import java.util.*;

import BinaryTree.TreeNode;
import LinkedList.*;

public class Test{

    public TreeNode reverseOddLevels(TreeNode root) {
        return reverseOddLevels(root, 0);
    }

    private TreeNode reverseOddLevels(TreeNode root, int height) {
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = reverseOddLevels(root.left, height + 1);
        TreeNode right = reverseOddLevels(root.right, height + 1);
        if (height % 2 == 0) {
            root.left = right;
            root.right = left;
        }
        else {
            root.left = left;
            root.right = right;
        }
        return root;
    }

    public static void main(String[] args) {
        Test test = new Test();
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(0);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(0);
        TreeNode t8 = new TreeNode(1);
        TreeNode t9 = new TreeNode(1);
        TreeNode t10 = new TreeNode(1);
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2);
        TreeNode t13 = new TreeNode(2);
        TreeNode t14 = new TreeNode(2);
        TreeNode t15 = new TreeNode(2);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t4.right = t9;
        t5.left = t10;
        t5.right = t11;
        t6.left = t12;
        t6.right = t13;
        t7.left = t14;
        t7.right = t15;

        test.reverseOddLevels(t1);
    }
}