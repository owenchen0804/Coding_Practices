package DFS;


import BinaryTree.TreeNode;

public class LC1372_LongestZigZagPathInABinaryTree {
    //  backTracking method
    public int longestZigZag(TreeNode root) {
        int[] max = new int[] {0};
        if (root == null) return 0;
        int currLength = 0;
        DFS(root, true, currLength, max);
        DFS(root, false, currLength, max);
        return max[0];
    }

    //  以下是backtracking的方法，是到一层做一层的事情，然后进入下一层，所以要有吃和吐的守恒
    //  所以这里isLeft是当前层给到下一层的信息，而不是从下面层获得返回的信息，和recursion不同！

    private void DFS(TreeNode root, boolean isLeft, int currLength, int[] max) {
        if (root == null) return;

        //  当前层做的事情，只是看看max是否需要更新
        max[0] = Math.max(max[0], currLength);

        if (isLeft) {
            //  还去左边，要reset currLength
            DFS(root.left, true, 1, max);
            DFS(root.right, false, currLength + 1, max);
        }
        else {
            DFS(root.left, true, currLength + 1, max);
            DFS(root.right, false, 1, max);
        }
    }





    //  Recursion method
    class ReturnType{
        int maxLength;  // globalMax：在当前subtree下面我见过的最长zigzag path长度
        int longestToLeft;  // 以我为开始向左走能走出的最长zigzag长度
        int longestToRight; //  以我为开始向右走能走出的最长zigzag长度
        public ReturnType(int maxLength, int longestToLeft, int longestToRight) {
            this.maxLength = maxLength;
            this.longestToLeft = longestToLeft;
            this.longestToRight = longestToRight;
        }
    }
    public int longestZigZag2(TreeNode root) {
        ReturnType result = recursion(root);
        return result.maxLength - 1;
    }

    private ReturnType recursion(TreeNode root) {
        if (root == null) {
            return new ReturnType(0,0,0);
        }
        ReturnType left = recursion(root.left);
        ReturnType right = recursion(root.right);

        int currentToRightMax = 1 + right.longestToLeft;
        int currentToLeftMax = 1 + left.longestToRight;
        //  因为left.max, right.max都是属于当前root的subtree拿到的最大值，也要考虑
        //  这两个值得来的不一定要经过当前的root，只要够大就会返回到上一层
        int currentMaxLength = Math.max(Math.max(currentToRightMax, currentToLeftMax), Math.max(left.maxLength, right.maxLength));

        return new ReturnType(currentMaxLength, currentToLeftMax, currentToRightMax);
    }
}
