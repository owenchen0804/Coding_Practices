package LeetCode;

public class LC88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1, right = n - 1, total = m + n - 1;
        while (left >= 0 && right >= 0) {
            if (nums1[left] < nums2[right]) {
                nums1[total--] = nums2[right--];
            }
            else {
                nums1[total--] = nums1[left--];
            }
        }
        // 如果是还剩left，说明n个nums2[]都排列好了，nums1就保持原样就行了
        while (right >= 0) {
            nums1[total--] = nums2[right--];
        }
    }
}
