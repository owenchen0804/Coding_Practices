package StrongerI;

public class LA116_LC80_ArrayDedupII {
    // 有重复也只保留2个一样的，在sorted array的前提下，只要比较fast和slow-2是否相等
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = 2;   // slow is exclusive
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] == nums[slow - 2]) {
                continue;
            }
            nums[slow++] = nums[fast];
        }
        return slow;
    }
}
