package Contest;

public class LC2210_CountHillsAndVallyesInAnArray {
    public int countHillValley(int[] nums) {
        int result = 0;
        int start = 0, i = 1;
        while (i < nums.length && nums[i] == nums[start]) {
            i++;
        }

        int end = nums.length - 2;
        while (end >= 0 && nums[end] == nums[nums.length - 1]) {
            end--;
        }

        while (i <= end) {
            while ((i + 1 <= end) && nums[i + 1] == nums[i]) {
                i++;
            }
            if (isRight(nums, start, i, i + 1)) {
                result++;
                start = i;
            }
            i++;
        }
        return result;
    }

    private boolean isRight(int[] nums, int a, int b, int c) {
        return (nums[b] < nums[a] && nums[b] < nums[c]) || (nums[b] > nums[a] && nums[b] > nums[c]);
    }
}
