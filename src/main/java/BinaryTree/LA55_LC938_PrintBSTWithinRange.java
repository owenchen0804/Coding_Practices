package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LA55_LC938_PrintBSTWithinRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(root, min, max, result);
        return result;
    }

    private void helper(TreeNode root, int min, int max, List<Integer> result) {
        if (root == null) {
            return;
        }
        //  按照increasing order所以应该In-order遍历BST，且要根据范围来选择去不去两个子树
        if (root.key > min) {   // == min 也不行，这样左子树一定还是比min要小
            helper(root, min, max, result); // max可能比root.key还小，所以这个range不能变要一直传下去！
        }
        if (root.key >= min && root.key <= max) {
            result.add(root.key);
        }
        if (root.key < max) {   //  == max也不行，因为这样的话右子树一定还是比max要大
            helper(root, min, max, result);
        }
    }
}