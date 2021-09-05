public class LA57_LC102_LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> curLayer = new ArrayList<>();
            int size = q.size();    // size表示当前这一层有多少nodes，那么就需要expand多少次！
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                curLayer.add(curr.key);
                if (curr.left != null) {
                    queue.offerLast(curr.left);
                }
                if (curr.right != null) {
                    queue.offerLast(curr.right);
                }
            }
            result.add(curLayer);
        }
        return result;
    }
}