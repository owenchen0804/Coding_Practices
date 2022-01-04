package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC349_IntersectionsOfArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> setA = new HashSet<>();
        for (int num : nums1) {
            setA.add(num);
        }
        List<Integer> common = new ArrayList<>();
        for (int num : nums2) {
            if (setA.contains(num)) {
                common.add(num);
                setA.remove(num);   // 很重要！避免duplicate result!
            }
        }
        int[] result = new int[common.size()];
        for (int i = 0; i < common.size(); i++) {
            result[i] = common.get(i);
        }
        return result;
    }
}
