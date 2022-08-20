package DPIV;

public class LC518_CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        //  dp[i]表示要凑到amount = i的币值有多少种方法
        dp[0] = 1;
        //  因为如果有coin = 2这个币种，那么凑币值 = 2的时候一定有一种方法的(拿1个2就可以)
        //  也就是当 == coin的时候一定有result = 1，所以dp[i - coin] = dp[0] = 1
        //  所以要把dp[0]设为1
        for (int coin : coins) {
            //  为了避免出现3 = 1 + 2 = 2 + 1这样的重复计算，外层的for loop应该是把coin的大小慢慢递增上去
            //  根据思路，每出一个coin币种，就从它开始往上直到amount，看由这个币种带来的解有多少
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
                //  比如amount = 10, coin 有2和5两种
                //  那么dp[10] += dp[8] => 而dp[8]又是一直往下到dp[2] += dp[0] = 1 传上来的，所以dp[8] = 1
                //  同理, dp[10] += dp[5] => dp[5] += dp[0] = 1
                //  因此，这个例子里面dp[10] = 1 + 1 = 2
            }
        }
        return dp[amount];
    }
}
