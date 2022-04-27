package DFS_II;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LC987_VerticalOrderTraversalOfBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //  思路是DFS，x表示当前竖直的Offset，y表示height, root的话就是0,0;
        //  如果往左走的话，x - 1表示左走，然后往下走y + 1表示高度+1。外层有一个
        //  TreeMap，key就是按顺序存不同的x的值，表示offset的不同。
        //  在遇到同一竖直,也就是x相同的情况都放到对应的value也就是内层TreeMap里
        //  之所以要这个TreeMap是为了按顺序存不同的y值，也就是说同样的vertical x值，
        //  y值较小的会在内层TreeMap的前面。
        //  内层TreeMap里面的key就是y值，对应的value是一个PriorityQueue
        //  原因是因为，完全相同的x,y值还要分出个高低，就是根据具体TreeNode.val来判断
        //  所以里面还要存每个TreeNode.val

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        DFS(root, 0, 0, map);
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            //  外层的key x值是有序的，所以这里拿到的也是从x最小值开始，不需要拿到keySet()
            //  每一个内层list都要new出来
            result.add(new ArrayList<>());
            //  然后按照逆序把PQ里面存的值一个个放到result对应的内层list中
            //  注意这里同一个PQ里面存的一定是x,y都相等，但是node.val不等
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    result.get(result.size() - 1).add(nodes.poll());
                }
            }
        }
        return result;
    }

    private void DFS(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        //  到叶子节点退出
        if (root == null) {
            return;
        }
        //  如果有新的x值要新建外层TreeMap，因为外层的Key根据x值来的
        //  如果有新的y值要新建内层的TreeMap，同理
        //  因为都是int类型的在变，所以不需要吃和🤮
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new PriorityQueue<>());
        }
        //  别忘了当前层的操作：把node要放到PQ中去！
        map.get(x).get(y).offer(root.key);
        DFS(root.left, x - 1, y + 1, map);
        DFS(root.right, x + 1, y + 1, map);
    }
}

