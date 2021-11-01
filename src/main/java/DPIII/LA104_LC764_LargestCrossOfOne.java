package DPIII;

import java.util.HashSet;
import java.util.Set;

public class LA104_LC764_LargestCrossOfOne {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        Set<Integer> zero = new HashSet<>();
        //  这题很巧妙的用row * n + col表示了所有的坐标且具有了唯一性，可以放到hashSet里面查重
        for (int[] mine : mines) {
            zero.add(mine[0] * n + mine[1]);
        }
        int longest = 0, count;
        for (int r = 0; r < n; r++) {   // 每一行都要左右看过去
            count = 0;
            for (int c = 0; c < n; c++) {   // 从左往右看
                count = zero.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = count;
            }
            count = 0;
            for (int c = n - 1; c >= 0; c--) {  // 从右往左看
                count = zero.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }
        // count = 0;
        // count 必须在每次到某一行/列往上/下/左/右看的时候要reset为0！
        for (int c = 0; c < n; c++) {
            count = 0;
            for (int r = 0; r < n; r++) {
                count = zero.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
            count = 0;
            for (int r = n - 1; r >= 0; r--) {
                count = zero.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                longest = Math.max(dp[r][c], longest);
            }
        }
        return longest;
    }
}
