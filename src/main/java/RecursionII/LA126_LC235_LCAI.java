package RecursionII;

import BinaryTree.TreeNode;

public class LA126_LC235_LCAI {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);
        if (leftResult == null && rightResult == null) {
            return null;
        }
        if (leftResult != null && rightResult != null) {
            return root;
        }
        else {
            return leftResult == null ? rightResult : leftResult;
        }
    }
    //  扩展思考：如果不保证p or q一定在tree里面呢？
    //  如果返回的root 既不是p也不是q，说明p & q 一定不是隶属关系，那么一定都在tree上
    //  如果返回了p or q，则可能是隶属，也可能只有返回的那个在tree上
    //  比如返回的是p，我们可以在以p为root的tree里面找q! 所以就是加上
    //  可以再次call lowestCommonAncestor(p, q, q) 因为q和q的LCA一定是自己！
    //  if (root == p) {
    //      if (lowestCommonAncestor(p, q, q) == null) {
    //          return null;
    //      }
    //  }
    //  同理对于q的操作一致！
}
