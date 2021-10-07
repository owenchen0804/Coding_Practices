package DPII;

public class LA89_LC45_JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        // dp[i] means how many steps needed from index i to the last index
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = -1; // 给初始值表示-1是跳不到终点的
            if (i + nums[i] >= nums.length - 1) {
                dp[i] = 1;
                continue;
            }
            else {
                for (int j = i + 1; j < nums.length; j++) {
                    //  先要满足i能跳到j，并且M[j] != -1
                    if (dp[j] != -1 && i + nums[i] >= j) {
                        if (dp[i] == -1 || dp[i] > dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                        }
                    }

                }
            }
        }
        return dp[0];
    }
}
