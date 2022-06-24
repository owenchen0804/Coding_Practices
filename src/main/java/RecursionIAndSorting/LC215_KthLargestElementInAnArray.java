package RecursionIAndSorting;

public class LC215_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {

        quickSelect(nums, 0, nums.length - 1, k - 1);
        // array是被写入heap的，所以不需要返回值也能写入
        return nums[k - 1];
    }

    private void quickSelect(int[] nums, int left, int right, int target) {
        int pivotIndex = partition(nums, left, right);
        if (pivotIndex == target) {
            return;
        }
        if (pivotIndex < target) {
            quickSelect(nums, pivotIndex + 1, right, target);
        }
        else {
            quickSelect(nums, left, pivotIndex - 1, target);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left, j = right - 1;
        while (i <= j) {
            if (nums[i] > pivot) {
                i++;
            }
            else if (nums[j] <= pivot) {
                j--;
            }
            else {
                swap(nums, i++, j--);
            }
        }
        //  别忘了要把Pivot换到i所在的地方！！！
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
