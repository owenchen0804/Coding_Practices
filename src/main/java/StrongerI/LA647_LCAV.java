package StrongerI;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class KnaryTreeNode {
      int key;
      List<KnaryTreeNode> children;
      public KnaryTreeNode(int key) {
          this.key = key;
          this.children = new ArrayList<>();
      }
  }

public class LA647_LCAV {
    public KnaryTreeNode findLCA(KnaryTreeNode root, KnaryTreeNode one, KnaryTreeNode two) {
        if (root == null || root == one || root == two) {
            return root;
        }
        KnaryTreeNode found = null;
        for (KnaryTreeNode child : root.children) {
            KnaryTreeNode node = findLCA(child, one, two);
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
