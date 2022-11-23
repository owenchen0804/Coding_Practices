package String;

public class LA670_LC487_MaxConsecutiveOnesII {
    public int max(int[] nums) {
        int slow = 0, fast;
        int flag = 1;
        for (fast = 0; fast < nums.length; fast++) {
            //  只要为0，那么就会让flag--，下不封顶
            if (nums[fast] == 0) {
                flag--;
            }
            //  只要小于0，就需要进到这里看看，且只有nums[slow] = 0的时候可以帮助恢复flag
            if (flag < 0) {
                flag += 1 - nums[slow];
                slow++;
            }
        }
        //  由于只要flag为负数都会slow++，所以到最后fast走完，和slow的差值就是答案
        return fast - slow;
    }
}
