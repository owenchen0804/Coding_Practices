package Contest;

public class LC2210_CountHillsAndVallyesInAnArray {

    //  其实不用下面的解法那么复杂，只需要给一个Left值，跟着i往前走，符合条件的话那么left的值就是这一次的a[i]
    public int countHillValley(int[] a){
        int r = 0, left = a[0];
        for(int i = 1; i < a.length - 1; i++)
            if(left < a[i] && a[i] > a[i + 1] || left > a[i] && a[i] < a[i + 1]){
                r++;
                left = a[i];
            }
        return r;
    }

    public int countHillValleyComplex(int[] nums) {
        int result = 0;
        int start = 0, i = 1;
        while (i < nums.length && nums[i] == nums[start]) {
            i++;
        }

        int end = nums.length - 2;
        while (end >= 0 && nums[end] == nums[nums.length - 1]) {
            end--;
        }

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
}
