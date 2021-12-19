package RecursionIII;

import BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC437_PathSumToTargetCount {
    int k;
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>(0, 1);
    // 这里不支持赋值初始化构造map函数！所以(0, 1)没有用！
    // 以上都会被用到但是不好作为返回值，所以设计为member field针对算法题比较好

    private void preorder(TreeNode root, int curSum) {
        if (root == null) return;
        curSum += root.key;
        // count = curSum == k ? count + 1 : count; 这个是equivalent to map.put(0, 1)
        count += map.getOrDefault(curSum - k, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        preorder(root.left, curSum);
        preorder(root.right, curSum);

        map.put(curSum, map.get(curSum) - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        map.put(0, 1);
        preorder(root, 0);
        return count;
    }
}
