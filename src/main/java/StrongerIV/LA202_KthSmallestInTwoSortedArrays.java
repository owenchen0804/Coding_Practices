package StrongerIV;

public class LA202_KthSmallestInTwoSortedArrays {
    public int kth(int[] a, int[] b, int k) {
        // Assume a, b are not null, not empty
        // Assume k >= 1, k <= a.length + b.length
        return helper(a, 0, b, 0, k);
    }

    private int helper(int[] a, int aLeft, int[] b, int bLeft, int k) {
        // base case 3 scenarios
        // 如果a or b直接撸完了，那么直接返回另外一个array[]的具体一个index就好
        // 如果 k == 1 剩最后一个了，那么直接取a, b二者较小的那个

    }
}
