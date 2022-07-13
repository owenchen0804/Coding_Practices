package Array;

import java.util.Arrays;

public class LC2294_PartitionArraySuchThatMaxDiffIsK {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums.length == 1) {
            return 1;
        }
        int slow = 0, fast = 1;
        int count = 0;
        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] <= nums[slow] + k) {
                fast++;
            }
            //  走到这里说明fast已经超过了
            count++;
            slow = fast;
        }
        return count;
    }
}
