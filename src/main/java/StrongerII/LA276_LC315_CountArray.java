package StrongerII;

import java.util.ArrayList;
import java.util.List;

public class LA276_LC315_CountArray {
    public List<Integer> countSmaller(int[] nums) {
        int[] countArray = new int[nums.length];
        int[] indexArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexArray[i] = i;
        }
        int[] helperArray = new int[nums.length];
        mergeSort(nums, indexArray, helperArray, countArray, 0, nums.length - 1);
        List<Integer> result = new ArrayList<>();
        for (int i : countArray) {
            result.add(i);
        }
        return result;
    }

    private void mergeSort(int[] nums, int[] indexArray, int[] helperArray,
                           int[] countArray, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, indexArray, helperArray, countArray, left, mid);
        mergeSort(nums, indexArray, helperArray, countArray, mid + 1, right);
        merge(nums, indexArray, helperArray, countArray, left, mid, right);
    }

    private void merge(int[] nums, int[] indexArray, int[] helperArray,
                       int[] countArray, int left, int mid, int right) {
        copy(indexArray, helperArray, left, right);
        int l = left, cur = left, r = mid + 1;
        while (l <= mid) {
            if (r > right || nums[helperArray[l]] <= nums[helperArray[r]]) {
                // 左边比右边小，需要清算countArray
                countArray[helperArray[l]] += r - mid - 1;
                indexArray[cur++] = helperArray[l++];
            }
            else {
                indexArray[cur++] = helperArray[r++];
            }
        }
    }

    private void copy(int[] indexArray, int[] helperArray, int left, int right) {
        for (int i = left; i <= right; i++) {
            helperArray[i] = indexArray[i]; // 记录上一次merge()的index排序的地方
            //再展开这一次的排序
        }
    }
}
