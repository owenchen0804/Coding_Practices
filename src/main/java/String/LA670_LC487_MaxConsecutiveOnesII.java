package String;

public class LA670_LC487_MaxConsecutiveOnesII {
    public int max(int[] nums) {
        int slow = 0, fast;
        int flag = 1;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == 0) {
                flag--;
            }
            if (flag < 0) {
                flag += 1 - nums[slow];
                slow++;
            }
        }
        return fast - slow;
    }
}
