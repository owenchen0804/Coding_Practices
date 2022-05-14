package HashMap_HashSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC350_IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //  这里assume了nums1是更小的array，因此最多common数也不可能超过num1.length
        //  因此可以直接在nums1上进行操作。
        int k = 0 ; // 要保留的index从0开始
        for (int num : nums2) {
            // if (map.containsKey(num)) { 不可以是containsKey!!因为value为0了但是key还在！
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                nums1[k++] = num;
                map.put(num, count - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
