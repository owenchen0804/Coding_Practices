package Contest;

public class LC2161_PartitionArrayAccordingToGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                result[k++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pivot) {
                result[k++] = pivot;
            }
        }
        int l = result.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > pivot) {
                result[l--] = nums[i];
            }
        }
        return result;
    }
}
