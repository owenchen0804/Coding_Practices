package Array;

import java.util.HashMap;
import java.util.Map;

public class LC2295_ReplaceElementsInAnArray {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //  key存的是index, value存的是值，这样可以用map.replace()
            mapA.put(i, nums[i]);
            //  mapB反过来，因为需要O(1)的时间找到operations[i][0]所在的key也就是index
            mapB.put(nums[i], i);
        }
        for (int[] operation : operations) {
            int index = mapB.get(operation[0]);
            mapA.replace(index, operation[1]);
            mapB.put(operation[1], index);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = mapA.get(i);
        }
        return result;
    }
}
