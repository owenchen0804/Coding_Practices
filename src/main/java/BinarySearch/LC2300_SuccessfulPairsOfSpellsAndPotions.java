package BinarySearch;

import java.util.Arrays;

public class LC2300_SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        int n = spells.length, m = potions.length;
        for (int i = 0; i < n; i++) {
            long target = success % spells[i] == 0 ? success / spells[i] : success / spells[i] + 1;
            int index = binarySearch(potions, target, 0, m - 1);
            result[i] = m - index;
        }
        return result;
    }

    private int binarySearch(int[] array, long target, int left, int right) {
        //  we need to find the smallest index that makes array[index] >= target

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        if (array[left] >= target) {
            return left;
        }
        if (array[right] >= target) {
            return right;
        }
        return array.length;
    }
}
