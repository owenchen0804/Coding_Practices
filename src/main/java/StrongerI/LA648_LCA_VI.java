package StrongerI;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class LA648_LCA_VI {
    public KnaryTreeNode findLCA(KnaryTreeNode root, List<KnaryTreeNode> nodes) {

        Set<KnaryTreeNode> set = new HashSet<>();
        return helper(root, set);
    }

    private KnaryTreeNode helper(KnaryTreeNode root, Set<KnaryTreeNode> set) {
        if (root == null || set.contains(root)) {
            return root;
        }
        KnaryTreeNode found = null;
        for (KnaryTreeNode child : root.children) {
            KnaryTreeNode node = helper(child, set);
            if (node == null) {
                continue;
            }
            else if (found == null) {
                found = node;
            }
            else {  // node不为null，且
                return root;
            }
        }
        return found;
    }


}
