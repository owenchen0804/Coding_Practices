package TwoPointers;

public class LC75_SortColors {
    public void sortColors(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int i = 0, j = 0, k = nums.length - 1;
        //  [0, i) i (not including i) are all 0
        //  [i, j) (including i, but not including j) are all 1
        //  (k, ) (not including k) are all 2
        //  [j, k] from j to k is unknown section to be explored
        while (j <= k) {
            if (nums[j] == 0) {
                swap(nums, j, i);
                i++;
                j++;
            }
            else if (nums[j] == 1) {
                j++;
            }
            else {
                swap(nums, j, k);
                k--;
            }
        }
    }

    private void swap(int[]array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
