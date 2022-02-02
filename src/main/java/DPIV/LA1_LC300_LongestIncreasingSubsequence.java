package DPIV;

import java.util.Arrays;

public class LA1_LC300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] lowestEnding = new int[nums.length + 1];
        lowestEnding[1] = nums[0];
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            //  用Binary Search的办法在lowestEnding[]这个递增序列中
            //  找到[1, 当前长度result]中比nums[i]小一点的最大值(不能等于)
            //  如果index就是result的值，说明都比nums[i]小，那么lowestEnding[++result] = num[i]
            //  如果index在中间的话，那么对应的lowestEnding[index+1] = nums[i]
            //  即该元素变得更小，但还是维持了lowestEnding的单调递增
            int index = findLargestSmaller(lowestEnding, 1, result, nums[i]);
            if (index == result) {
                lowestEnding[++result] = nums[i];
            }
            else {
                lowestEnding[index + 1] = nums[i];
            }
        }
        return result;
    }

    private int findLargestSmaller(int[] array, int left, int right, int target) {
        while (left < right - 1) {
            // while循环的终止条件是还剩left, right两个Index的时候停下来
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }
        if (array[right] < target) {
            return right;
        }
        if (array[left] < target) {
            return left;
        }
        return 0;
    }
}
