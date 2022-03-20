package Contest;

public class Test2 {
    public int countHillValley(int[] nums) {
        int result = 0;
        int start = 1;
        while (nums[start] == nums[0]) {
            start++;
        }
        int i = start;
        int end = nums.length - 2;
        while (nums[end] == nums[nums.length - 1]) {
            end--;
        }
        int j = end;
        while (i <= end) {
            while ((i + 1 <= end) && nums[i + 1] == nums[i]) {
                i++;
            }
            if (isRight(nums, start, i, i + 1)) {
                result++;
                start = i;
            }
            i++;
        }
        return result;
    }

    private boolean isRight(int[] nums, int a, int b, int c) {
        return (nums[b] < nums[a] && nums[b] < nums[c]) || (nums[b] > nums[a] && nums[b] > nums[c]);
    }

    public static void main(String[] args) {
        Test2 test = new Test2();
        int[] nums = {2,4,1,1,6,5};
        test.countHillValley(nums);
    }
}
