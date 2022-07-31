package DPIV;

public class LC377_CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            //  由于这里3 = 1 + 2 = 2 + 1 算2组解，那么外层for loop应该是从不同的amount，从1开始往上build
            for (int coin : nums) {
                if (i >= coin) {
                    //  这一步是为了dp[i]里的i变成了负数，会出现OOB的run time error
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[target];
    }
}
