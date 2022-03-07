package Contest;

import java.util.Arrays;
import java.util.Comparator;

public class LC2191_SortTheJumbledNumbers {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Arrays.sort()里面传的comparator只能对class Integer，不能对int[]，所以必须要有这么一步转化！
        int n = nums.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        //  思路是把index按照Mapping后的大小进行sort，然后再copy到result[]里
        //  注意下面的写法，非常重要！！
        Arrays.sort(indices, Comparator.comparing(i -> convert(nums[i], mapping)));
        int[] result = new int[n];
        int k = 0;
        for (int idx : indices) {
            result[k++] = nums[idx];
        }
        return result;
    }

    private int convert(int num, int[] mapping) {
        if (num == 0) {
            return mapping[0];  //  注意这个特殊情况，不会进入到while()循环中
        }
        int n = 0, f = 1;
        while (num > 0) {
            n += mapping[(num % 10)] * f;
            f *= 10;
            num /= 10;
        }
        return n;
    }

    public static void main(String[] args) {
        LC2191_SortTheJumbledNumbers test = new LC2191_SortTheJumbledNumbers();
        int[] mapping = {0,1,2,3,4,5,6,7,8,9};
        int[] nums = {0,999999999};
        System.out.println(test.sortJumbled(mapping, nums));
    }
}
