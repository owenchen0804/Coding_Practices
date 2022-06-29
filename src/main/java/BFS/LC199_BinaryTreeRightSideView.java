package BFS;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null) return ret;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int cnt = q.size();
            for(int i = 0;i < cnt;i++){
                TreeNode cur = q.poll();
                if(i == cnt-1){
                    ret.add(cur.key);
                }
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
        }
        return ret;
    }
    //  DFS
     public List<Integer> rightSideView2(TreeNode root) {
         List<Integer> result = new ArrayList<Integer>();
         rightView(root, result, 0);
         return result;
     }

     public void rightView(TreeNode curr, List<Integer> result, int currDepth){
         if(curr == null){
             return;
         }
         if(currDepth == result.size()){
             result.add(curr.key);
         }

         rightView(curr.right, result, currDepth + 1);
         rightView(curr.left, result, currDepth + 1); //  因为有可能右边为空，只有左边，所以也要访问!

     }
}
