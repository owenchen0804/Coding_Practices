package DPI;

public class LA88_LC55_JumpGameI {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            //  直接靠自己
            if (i + nums[i] >= nums.length - 1) {
                dp[i] = true;
            }
            else {  // 靠先跳到后面的能够到终点的点
                for (int j = i + 1; j < nums.length; j++) {
                    if (dp[j] && i + nums[i] >= j) {
                        dp[i] = true;
                        break;
                    }
                }
            }

        }
        return dp[0];
    }

    // Greedy 贪心算法
    // maxReach是初始值为0，随着i的变化，我们要incremental update maxReach = Math.max(maxReach, i + nums[i])
    // 当发现存在某个i，且i > maxReach的时候，表明无论如何maxReach也到不了index = i了，就要return false

    public boolean canJumpII(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
