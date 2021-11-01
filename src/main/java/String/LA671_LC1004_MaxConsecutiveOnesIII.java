package String;

public class LA671_LC1004_MaxConsecutiveOnesIII {
    public int longestConsecutiveOnes(int[] nums, int k) {
        // Write your solution here
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                k--;
            }
            if (k < 0) {
                k += 1 - nums[left];
                left++;
            }
        }
        return right - left;
    }
}
