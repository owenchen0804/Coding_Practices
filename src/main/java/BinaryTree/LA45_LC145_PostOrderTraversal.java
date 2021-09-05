public class LA45_LC145_PostOrderTraversal {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        //  TreeNode curr = root;
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peekFirst();
            // 当prev在curr的上方的时候，要左右子树先进stack
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != left) {
                    //  curr = curr.left;
                    //  stack.offerFirst(curr);
                    //  curr 不能在这里走，而是靠每次peekFirst()前进，因为每次while循环末尾prev = curr
                    //  才会产生prev和curr不同的相对位置，从而产生以下的情况讨论！
                    stack.offerFirst(curr.left);
                }
                else if (curr.right != null) {
                    //  curr = curr.right;
                    stack.offerFirst(curr.right);
                }
                else {
                    result.add(stack.pollFirst().key);
                }
            }
            else if (curr.left == prev) {
                // prev为curr的左子树，那么表明左分支处理完毕还需要到右边
                if (curr.right != null) {
                    stack.offerFirst(curr.right);
                }
                else {
                    result.add(stack.pollFirst().key);
                }
            }
            else {// prev在curr的右子树，也就是curr.right == prev 说明右子树遍历结束，可以打印自己了
                result.add(stack.pollFirst().key);
            }
            prev = curr;
        }
        return result;
    }
}