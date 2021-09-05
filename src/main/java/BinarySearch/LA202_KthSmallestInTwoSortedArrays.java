public class LA202KthSmallestInTwoSortedArrays {
    public int kth(int[] a, int[] b) {
        return kth(a, 0, b, 0, k);
    }

    private int kth(int[] a, int aLeft, int[] b, int bLeft, int k) {

        if (aLeft >= a.length) {
            return b[bLeft + k - 1];
        }
        if (bLeft >= b.length) {
            return a[aLeft + k - 1];
        }
        if (k == 1) {
            // return a[aleft] <= b[bleft] ? a[aleft] : b[bleft];
            return Math.min(a[aleft], b[bleft]);
        }

        int amid = aLeft + k / 2 - 1;
        int bmid = bLeft + k / 2 - 1;
        int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
        int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
        if (aval <= bval) {
            return kth(a, amid + 1, b, bleft, k - k / 2);
        }
        return kth(a, aleft, b, bmid + 1, k - k / 2);
    }
}