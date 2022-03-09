package Contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC2195_AppendKIntegersWithMinimalSum {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        //  不用现在就加num值进去
        long sum = 0;
        for (int num : nums) {
            if (!set.contains(num) && num <= k) {
                // num正好等于k也不行，因为我也需要减掉num，并且把k多走一个，和<k的逻辑完全一致
                k++;
                sum += num; // num出现在k的范围内，要把k多走一个，并且num要加到sum里面最后减掉
            }
            set.add(num);   // 不管如何都需要加到set里面去重
        }
        long result = (long) k * (1 + k) / 2 - sum;
        return result;
    }
}
