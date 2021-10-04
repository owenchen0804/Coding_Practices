package DPI;

public class LA86_LC1800_MaxAscendingSum {
    public int maxAscendingSum(int[] nums) {
        int globalMax = nums[0]; // 至少以自己为1个连续
        // dp思路，只需要remember the latest dp[i]
        // 所以不需要一个M[] array来memorize all the previous results
        int curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curMax += nums[i];
                globalMax = Math.max(globalMax, curMax);
            }
            else {
                curMax = nums[i];
            }
        }
        return globalMax;
    }
}
