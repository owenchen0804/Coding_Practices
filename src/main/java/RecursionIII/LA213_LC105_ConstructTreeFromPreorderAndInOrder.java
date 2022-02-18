package RecursionIII;

import BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LA213_LC105_ConstructTreeFromPreorderAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
            //  记录每个Treenode的值作为map的key；
            //  对应inorder[]所在的index作为map的value
        }
        return helper(preorder, indexMap, 0, inorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, Map<Integer, Integer> indexMap, int inLeft, int inRight, int preLeft, int preRight) {
        if (inLeft > inRight) {
            // 注意这里base case 一定要是inLeft > inRight，不能等于！否则的话当前root的左边只有一个a的话，
            // 应该root.left = a的，但是如果可以等于，相当于只有一个元素的时候就return null了，
            // 那么就相当于root.left = null了
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inMid = indexMap.get(root.key);
        root.left = helper(preorder, indexMap, inLeft, inMid - 1, preLeft + 1, preLeft + inMid - inLeft);
        // size = inRight - inLeft + 1 = inMid - 1 - inLeft + 1
        root.right = helper(preorder, indexMap, inMid + 1, inRight, preLeft + inMid - inLeft + 1, preRight);
        return root;
    }
}
