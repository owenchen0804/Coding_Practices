package DFS;
//  DFS + BFS

import BinaryTree.TreeNode;

import java.util.*;

public class LC863_AllNodesDistanceKinBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // DFS to build graph + BFS to get result
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        buildGraph(root, map, null);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // level order BFS
                TreeNode curr = queue.poll();
                if (level == k) {   // 如果就在level = k层，每次poll()出来都直接加到result里
                    result.add(curr.key);
                }
                for (TreeNode node : map.get(curr)) {
                    if (!visited.contains(node)) {
                        queue.offer(node);
                        visited.add(node);
                    }
                }
            }
            //  都加完了以后再来判断一次level是否到k了，没到就会继续level++
            if (level == k) {
                return result;
            }
            level++;

        }
        return result;
    }

    private void buildGraph(TreeNode root, Map<TreeNode, List<TreeNode>> map, TreeNode parent) {
        if (root == null) {
            return;
        }
        // 因为没有parent node，所以当前层必须要存parent <-> root之间的关系，应该属于无向图互相存关系
        map.putIfAbsent(root, new ArrayList<>());
        if (parent != null) {
            map.get(root).add(parent);
            map.get(parent).add(root);
        }
        buildGraph(root.left, map, root);
        buildGraph(root.right, map, root);
    }
}
