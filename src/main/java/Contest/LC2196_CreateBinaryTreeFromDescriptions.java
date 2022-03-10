package Contest;

import BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC2196_CreateBinaryTreeFromDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        //  为了避免key的重复，比如2次看到20，则不能重复new一个treenode
        //  同时我们放入map的都是child，但是child有可能也是parent，所以需要map来去重
        Map<Integer, TreeNode> map = new HashMap<>();

        //  set是用来找root的，只要是在parent[]里面找到不是child[]里面的，就是root了，只有它满足这个条件
        Set<Integer> children = new HashSet<>();

        for (int[] arr : descriptions) {
            // 对于每个arr来说，
            int parent = arr[0], child = arr[1], isLeft = arr[2];
            children.add(child);
            //  每次看看parent是否已经有该TreeNode存在，但是我们不放parent到map中，只放child
            //  但是child到后面也会可能是parent，所以没有关系，只是root不会放到map中去
            TreeNode node = map.getOrDefault(parent, new TreeNode(parent));
            if (isLeft == 1) {
                node.left = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.left);
            }
            else {
                node.right = map.getOrDefault(child, new TreeNode(child));
                map.put(child, node.right);
            }
            map.put(arr[0], node);
        }

        int root = -1;
        for (int[] arr : descriptions) {
            // children里面没有的在arr[1]中的一定就是root
            if (!children.contains(arr[0])) {
                root = arr[0];
                break;
            }
        }
        return map.get(root);
    }
}
