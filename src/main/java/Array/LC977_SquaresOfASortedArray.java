package Array;

public class LC977_SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1;
        int[] result = new int[nums.length];
        int k = result.length - 1;
        while (k >= 0) {
            if (Math.abs(nums[j]) >= Math.abs(nums[i])) {
                result[k--] = nums[j] * nums[j];
                j--;
            }
            else {
                result[k--] = nums[i] * nums[i];
                i++;
            }
        }
        return result;
    }
}
