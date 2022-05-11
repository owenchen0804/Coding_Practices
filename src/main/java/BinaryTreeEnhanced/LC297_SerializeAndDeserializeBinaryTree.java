package BinaryTreeEnhanced;

import BinaryTree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC297_SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('#').append(',');
        }
        else {
            sb.append(root.key).append(',');
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] d = data.split(",");
        List<String> list = Arrays.asList(d);
        Queue<String> q = new LinkedList<>(list);
        return buildTree(q);
    }

    private TreeNode buildTree(Queue<String> q) {
        //  因为题目是规定了，最后的叶子都是Null，以"#"的形式存在coded string里面
        //  所以在decode的时候最后q poll()出来的肯定也是"#"，就会return null，也就不会再继续poll()了
        //  所以不用担心没有到base case, q继续poll()会NPE；因为最后一个是"#"，Poll()出来之后return null了，会回上一层
        String s = q.poll();
        if (s.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = buildTree(q);
        root.right = buildTree(q);
        return root;
    }
}
