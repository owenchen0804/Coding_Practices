package BinarySearch;

public class LC1231_DivideChocolate {
    public int maximizeSweetness(int[] sweetness, int k) {
        //  这里注意，lower选的是input[]里面最小的，也就是说我选的target至少也要这么多
        //  比如k + 1 == sweetness.length的话，那么我能拿最小的一份就是input[]里面的最小值
        //  最多的情况就是比如k == 0的话只用分一份，那么我直接拿总和，那么max的最大值就是sum
        //  注意这里的helper()返回的不再是像isValid()那样是否true or false
        //  而是返回的切成多少份，那么回到主函数里面，如果份数<= k + 1说明选的target太多了，达不到，就要移动right，否则能达到的话就lower向右移动
        int lower = 0;
        int max = 0;
        for(int num : sweetness){
            lower = Math.min(num, lower);
            max += num;
        }

        while(lower < max){
            int mid = lower + (max - lower) / 2;
            int pieces = split(sweetness, mid);
            if(pieces <= k + 1){
                max = mid;
            }else{
                lower = mid + 1;
            }
        }

        return lower;
    }
    //  In this when we overshoot the target, we will include that number in previous sum, as that is how we will maintain the target as the minimum number and binary search will find this optimal minimum
    //  In "Split Array Largest sum" when we overshoot the target, we will include the number in the next sum, so we can ensure all numbers are less than target - binary search does the rest of the magic
    //  这里我用的是给一个最小的target，看看每一份都至少达到target的话能切成多少份，这里返回的不是true or false


    private int split(int[] nums, int target) {
        int pieces = 1;
        int count = 0;

        for (int num : nums) {
            if ((count + num) > target) {
                count = 0;
                pieces++;
            }
            else {
                count += num;
            }
        }
        return pieces;
    }
}
