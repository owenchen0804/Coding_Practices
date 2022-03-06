package Contest;

import java.util.Arrays;
import java.util.Comparator;

public class LC2191_SortTheJumbledNumbers {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[] newNums = new Integer[nums.length];
        int i = 0;
        for (int value : nums) {
            newNums[i++] = Integer.valueOf(value);
        }
        Arrays.sort(newNums, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if (getMapped(i1, mapping) < getMapped(i2, mapping)) {
                    return -1;
                }
                if (getMapped(i1, mapping) == getMapped(i2, mapping)) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
        });
        int[] result = new int[newNums.length];

        for (int j = 0; j < result.length; j++) {
            result[j] = newNums[j];
        }
        return result;
    }


    private static int getMapped(int num, int[] mapping) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(mapping[num % 10]);
            num /= 10;
        }
        StringBuilder result = sb.reverse();
        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        LC2191_SortTheJumbledNumbers test = new LC2191_SortTheJumbledNumbers();
        int[] mapping = {0,1,2,3,4,5,6,7,8,9};
        int[] nums = {0,999999999};
        System.out.println(test.sortJumbled(mapping, nums));
    }
}
