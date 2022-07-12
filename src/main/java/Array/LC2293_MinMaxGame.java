package Array;

public class LC2293_MinMaxGame {
    public int minMaxGame(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        while (nums.length > 2) {
            int[] newNums = new int[nums.length / 2];
            for (int i = 0; i < newNums.length; i++) {
                if (i % 2 == 0) {
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);

                }
                else {
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = newNums;
        }

        return Math.min(nums[0], nums[1]);
    }
}
