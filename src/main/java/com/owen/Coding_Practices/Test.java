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
        long a;
        //`System.out.print(Long.compare(a, 1));
    }
}