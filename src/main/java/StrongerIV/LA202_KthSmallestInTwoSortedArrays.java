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
        if (aLeft >= a.length) {
            return b[bLeft + k - 1];
        }
        if (bLeft >= b.length) {
            return a[aLeft + k - 1];
        }
        if (k == 1) {
            return Math.min(a[aLeft], b[bLeft]);
        }
        //  每次各取 k / 2这么多个数据，看看是否有数组越界了，越界的话应该保留先不看，总会等到k越来越小不越界
        //  哪怕a[] or b[]只有1个数据，也可以等到base case k = 1的情况
        //  我们之所以有这个信心，是因为要凑够k个最小的数，越界了的那一段保留，去除另一端的k/2个，总个数还是不会到k
        int aMid = aLeft + k / 2 - 1;
        int bMid = bLeft + k / 2 - 1;
        int aVal = aMid >= a.length ? Integer.MAX_VALUE : a[aMid];
        int bVal = bMid >= b.length ? Integer.MAX_VALUE : b[bMid];
        if (aVal <= bVal) {
            // 谁小谁这一半都可以淘汰
            return helper(a, aMid + 1, b, bLeft, k - k / 2);
        }
        else {
            return helper(a, aLeft, b, bMid + 1, k - k / 2);
        }
    }
}
