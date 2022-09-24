package RecursionIII;

import BinaryTree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LA141_BinaryTreePathSumToTargetIII {
    public boolean exist(TreeNode root, int target) {
        // Write your solution here
        if (root == null) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(0);//以防第一个就满足条件，那么prevSum - target就是0！
        return helper(root, set, 0, target);
    }

    private boolean helper(TreeNode root, Set<Integer> set, int prevSum, int target) {
        prevSum += root.key;
        if (set.contains(prevSum - target)) {
            return true;
        }
        boolean needRemove = set.add(prevSum);//如果是个新的值，在当前level加进set了需要记一下，后面要吐！
        if (root.left != null && helper(root.left, set, prevSum, target)) {//这里的prevSum是本层加过了root.key
            return true;
        }
        if (root.right != null && helper(root.right, set, prevSum, target)) {
            return true;
        }
        if (needRemove) {
            set.remove(prevSum);//set当前层的值减去后才回到上一层的状态不变。
        }
        return false;
    }
}
