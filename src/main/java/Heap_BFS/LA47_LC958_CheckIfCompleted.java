import java.util.Queue;

public class LA47_LC958_CheckIfCompleted {
    public boolean checkComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        //  判断方法是首次出现null的时候flag设为true; 之后如果flag == true且TreeNode不为null就说明错了。对于左右子树皆同一理
        boolean flag = false;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                q.offer(curr.left);
            }


            if (curr.right == null) {
                flag == true;
            } else if (flag) {
                return false;
            } else {
                q.offer(curr.right);
            }
        }
        return true;
    }
}