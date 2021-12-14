package StrongerII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j - i > 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // use 2 Sum here
                int sum = nums[i] + nums[j];
                // List<Integer> temp = new ArrayList<>();
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == target - sum) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left++],
                                nums[right--]));
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                    }
                    else if (nums[left] + nums[right] < target - sum) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
