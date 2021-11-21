package StrongerI;

public class LA115_LC26_ArrayDedupI {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;  // i is inclusive 所以如果nums[]只有一个数，也是返回i + 1 = 1
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
