package BinaryTreeEnhanced;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LA215_ReconstructBinaryTreeFromInorderAndLevelOrder {
    public TreeNode reconstruct (int[] level, int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        // map is to store the inorder element index, so to separate root.left and root.right
        List<Integer> list = new ArrayList<>();
        // list is to store all level order TreeNodes, and when remove(0) means the current
        // root is getting newed.
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);//记录了root的坐标，才知道比它小的应该都在左子树，大的都在右子树
        }
        for (int num : level) {
            list.add(num);
        }
        return helper(map, list);
    }

    private TreeNode helper(Map<Integer, Integer> map, List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(list.remove(0));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int num : list) {
            if (map.get(num) < map.get(root.key)) {
                left.add(num);
            }
            else {
                right.add(num);
            }
        }   //  对于这一个root的左右子树就都确定了，对于根root来说，相当于剩下的TreeNode
            //  左子树全到了left, 右子树全到了right
            //  然后根据level order的顺序，当前List的下一个必是左孩子，再下一个就是右孩子
        root.left = helper(map, left);
        root.right = helper(map, right);
        return root;
    }
}
