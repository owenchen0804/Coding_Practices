package Array;

import java.util.*;

public class LC2248_IntersectionOfMultipleArrays {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> result = toList(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            result = intersection(result, toList(nums[i]));
        }
        Collections.sort(result);
        return result;
    }

    private List<Integer> toList(int[] num) {
        List<Integer> list = new ArrayList<>();
        for (int n : num) {
            list.add(n);
        }
        return list;
    }

    private List<Integer> intersection(List<Integer> list1, List<Integer> list2) {
        List<Integer> inter = new ArrayList<>();
        Set<Integer> set = new HashSet<>(list1);
        for (int i : list2) {
            if (set.contains(i)) {
                inter.add(i);
            }
        }
        return inter;
    }
}
