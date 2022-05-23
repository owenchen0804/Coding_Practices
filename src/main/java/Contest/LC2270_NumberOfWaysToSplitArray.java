package Contest;

public class LC2270_NumberOfWaysToSplitArray {
    public int waysToSplitArray(int[] nums) {
        long sum1 = 0, sum2 = 0;
        for (int num : nums) {
            sum2 += num;
        }
        int count = 0;
        int index = 0;
        while (index <= nums.length - 2) {
            sum1 += nums[index];
            sum2 -= nums[index];
            if (sum1 >= sum2) {
                count++;
            }
            index++;
        }
        return count;
    }
}
