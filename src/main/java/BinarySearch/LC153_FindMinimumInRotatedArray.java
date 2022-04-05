package BinarySearch;

public class LC153_FindMinimumInRotatedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length -1;
        //  用Binary Search的办法找到右半边的最小值在的index
        //  如果>= nums[right]说明在左半边，需要调整left
        //  否则在右半边，应该移动right
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return nums[right];
    }
}
