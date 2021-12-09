package StrongerII;

import java.util.HashMap;
import java.util.Map;

public class LA180_LC1_2SUM {
    // 如果只是boolean返回true or false用hashSet就够了
    // 但是这里要返回index，所以只能用hashMap来存index还有对应的value
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
