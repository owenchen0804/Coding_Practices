package StrongerII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LA182_LC167_2SumAllPairII {
    public List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (left > 0 && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result.add(Arrays.asList(nums[left], nums[right]));
                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
