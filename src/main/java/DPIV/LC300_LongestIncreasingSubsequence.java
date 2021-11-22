package DPIV;

import java.util.Arrays;

public class LC300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] array1 = {3, 2, 2, 4, 5, 10, 6};
        //  对于没排序的数组还是会按照一般的BS方法看找到第一个>key的location，然后返回-(i) - 1;
        int[] array2 = {1, 2, 3, 4, 5, 6, 8};
        int result1 = Arrays.binarySearch(array2, 0, 5, 9);
        //  注意toIndex这里是exclusive的取不到，如果key比数组所有的都大， 那么返回值就是-(toIndex) - 1
        System.out.println(result1);
    }
}
