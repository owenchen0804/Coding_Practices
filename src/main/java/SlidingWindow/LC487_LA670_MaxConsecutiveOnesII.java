package SlidingWindow;

public class LC487_LA670_MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int slow = 0, fast;
        int flag = 1;
        for (fast = 0; fast < nums.length; fast++) {
            //  这里奇特的点不需要increasingly update
            //  原因是因为每一步fast都会往前走，即使当flag < 0 的时候也是
            //  slow在flag < 0 的时候往前走，那么fast - slow的相对位置，也就是差值是不变的
            //  它不会减少，因为fast,slow都在右移，只会等后面flag重新>=0了之后扩大
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
