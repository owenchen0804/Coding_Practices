package StrongerII;

import java.util.HashSet;
import java.util.Set;

public class LA180_2SUM {
    public boolean twoSum(int[] array, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            if (set.contains(target - i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}