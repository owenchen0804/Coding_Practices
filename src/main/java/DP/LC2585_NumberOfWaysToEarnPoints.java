package DP;

public class LC2585_NumberOfWaysToEarnPoints {
    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        int mod = 1000000007;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int count = types[i][0];
            int mark = types[i][1];
            for (int j = target; j >= mark; j--) {
                for (int k = 1; k <= count && j - k * mark >= 0; k++) {
                    dp[j] = (dp[j] + dp[j - k * mark]) % mod;
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        LC2585_NumberOfWaysToEarnPoints test = new LC2585_NumberOfWaysToEarnPoints();
        int[][] types = {{6,1}, {3,2}, {2,3}};
        test.waysToReachTarget(6, types);
    }
}
