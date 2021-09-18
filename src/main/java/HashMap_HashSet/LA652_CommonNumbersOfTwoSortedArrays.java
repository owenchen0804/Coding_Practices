package HashMap_HashSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//  a[] and b[] can have duplicated numbers!
public class LA652_CommonNumbersOfTwoSortedArrays {
    public List<Integer> findCommon(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        for (int num : a) {
            mapA.put(num, mapA.getOrDefault(num, 0) + 1);
        }
        for (int num : b) {
            mapB.put(num, mapB.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: mapA.entrySet()) {
            //  int countA = entry.getValue();
            int countB = mapB.getOrDefault(entry.getKey(), 0);
            int common = Math.min(countB, entry.getValue());
            for (int i = 0; i < common; i++) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
