package TwoPointers;

import java.util.Arrays;

public class LC259_3SumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] < target) {
                    count += right - left;
                    //  这里的意思是，i, left, right能组合的话，那么i, left, right - 1,
                    //  i, left, right - 2, ... 一直到i, left, left + 1 都是满足要求的
                    //  因此right - left就代表了从i, left，[]这三个到底有多少个！
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return count;
    }
}
