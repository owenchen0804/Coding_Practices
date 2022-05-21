package BitOperation;

public class LC338_CountingBits {
    //  DP的思想，容易得出来的结论
    //  P(x) = P(x & (x - 1)) + 1
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int x = 1; x <= num; ++x) {
            ans[x] = ans[x & (x - 1)] + 1;
        }
        return ans;
    }

    public int[] countBits2(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }
}
