package Probability;

import java.util.Random;

public class LC398_RandomPickIndex {
    private int[] nums;
    private Random rand;

    public LC398_RandomPickIndex(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int idx = 0;
        for (int i = 0; i < this.nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt(count) == 0) { // 每多一个count，都会先++,之后再从里面uniformly random选择一个
                    // 且每次都是如果正好选出来是0的话就idx赋值，这个相当于是把有且只有一个target的情况包括了
                    //  因为如果target只出现一次，那么nextInt(1) 一定是0，因为这个会选出[0, count)的随机数
                    idx = i;
                }
            }
        }
        return idx;
    }
}

