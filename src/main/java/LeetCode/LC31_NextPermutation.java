package LeetCode;//  TC: O(n) 找left and right最多各花O(n)的时间，最后reverse也同样是O(n)
//  SC: O(1) 这是in-place的操作

public class LC31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int left = nums.length - 2;
        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }
        if (left < 0) {
            reverse(nums, 0 , nums.length - 1);
        }
        else {
            int right = nums.length - 1;
            while (nums[right] <= nums[left]) {
                right--;
            }
            swap(nums, left, right);
            reverse(nums, left + 1, nums.length - 1);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}