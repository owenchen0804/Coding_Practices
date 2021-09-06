package RecursionAndSorting;

public class LA9_MergeSort {
    public int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int[] helper = new int[array.length];
        //return mergeSort(array, helper, 0, array.length - 1);
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        //  谁小移谁
        int j = left, k = mid + 1;
        while (j <= mid && k <= right) {
            if (helper[j] <= helper[k]) {
                array[left] = helper[j++];
            }
            else {
                array[left] = helper[k++];
            }
            left++;
        }
        while (j <= mid) {
            array[left++] = helper[j++];
        }
    }
}