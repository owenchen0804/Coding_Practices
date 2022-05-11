package BinaryTreeEnhanced;

import BinaryTree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LA141_BinaryTreePathSumToTargetIII {
    public boolean sumToTarget(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(0); // 后面用currSum - target，如果为0表示满足题意应该return true
        return helper(root, set, 0, target);
    }

    private boolean helper(TreeNode root, Set<Integer> set, int curSum, int target) {
        // no base case, 如果以下几种情况都没法成立，就要返回false了
        curSum += root.key;
        if (set.contains(curSum - target)) {
            return true;
        }
        boolean needRemove = set.add(curSum);
        // 如果curSum作为新的值加入到set的话，需要吐出来，类似DFS
        // 但如果之前有这个值，那么needRemove会是false，就不用吐了
        // 那个第一次得到这个值的root在往上backtrack的时候会吐的
        if (root.left != null && helper(root.left, set, curSum, target)) {
            return true;
            // return helper(root.left, set, curSum, target);
            // 错误写法，这样如果左孩子确实是false，那么当前root就直接返回false，不会走到右孩子那边了！
        }
        if (root.right != null && helper(root.right, set, curSum, target)) {
            return true;
        }
        if (needRemove) {
            set.remove(curSum); //🤮
        }
        return false;   // 以上条件都不满足只好返回false
    }


    public static void main(String[] args) {
        LA141_BinaryTreePathSumToTargetIII test = new LA141_BinaryTreePathSumToTargetIII();
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(11);
        TreeNode t4 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        System.out.println(test.sumToTarget(t1, 17));
    }
}
