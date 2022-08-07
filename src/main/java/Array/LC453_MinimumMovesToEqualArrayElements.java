package Array;

public class LC453_MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        //  一共n个数字，每一次给其中 n - 1 elements加上1， is the same as subtracting 1 from one element
        //  也就是相当于只把1个数 - 1，就是一次操作move
        //  w.r.t goal of making the elements in the array equal.
        //  So, the best way to do this is make all the elements in the array equal to the min element.
        if (nums.length == 1) {
            return 0;
        }
        int min = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (num < min) {
                min = num;
            }
        }
        return sum - nums.length * min;
    }
}
