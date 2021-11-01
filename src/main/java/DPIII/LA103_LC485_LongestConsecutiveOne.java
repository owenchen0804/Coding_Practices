package DPIII;

public class LA103_LC485_LongestConsecutiveOne {
    public int findMaxConsecutiveOnes(int[] nums) {
        int lastMax = nums[0] == 1 ? 1 : 0;
        int longest = lastMax;
        for (int i = 1; i < nums.length; i++) {
            lastMax = nums[i] == 0 ? 0 : lastMax + 1;
            longest = Math.max(longest, lastMax);
        }
        return longest;
    }
}
