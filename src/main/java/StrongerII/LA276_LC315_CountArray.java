package StrongerII;

import java.util.ArrayList;
import java.util.List;

public class LA276_LC315_CountArray {
    public int[] countArray(int[] array) {
        // Write your solution here
        int[] indexArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            indexArray[i] = i;
        }
        int[] helper = new int[array.length];
        int[] countArray = new int[array.length];
        mergeSort(array, indexArray, countArray, helper, 0, array.length - 1);
        return countArray;
    }

    private void mergeSort(int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, indexArray, countArray, helper, left, mid);
        mergeSort(array, indexArray, countArray, helper, mid + 1, right);
        merge(array, indexArray, countArray, helper, left, mid, right);
    }

    private void merge(int[]array, int[]indexArray, int[]countArray, int[] helper, int left, int mid, int right) {
        copyArray(indexArray, helper, left, right);
        int cur = left;
        int l = left, r = mid + 1;
        while (l <= mid) {
            if (r > right || array[helper[l]] <= array[helper[r]]) {
                countArray[helper[l]] += r - mid - 1; //counterArray存的也都是对于helper[i]这个index有多少比它小的逆序数
                //  这里是l对应的数该清算了，因为要么r出界了，要么是r对应的值超过了l对应的值
                //  现在就把l对应的坐标放到当前的indexArray[cur]中
                indexArray[cur++] = helper[l++];
            }
            else {
                indexArray[cur++] = helper[r++];  // array[helper[r]]更小，就把它放到cur所对应的indexArray[cur]
            }
        }
    }

    private void copyArray(int[] indexArray, int[] helper, int left, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = indexArray[i];
        }
    }
}
