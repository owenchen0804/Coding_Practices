public class LC33_LC81_SearchRotatedSortedArray {
    // e.g. array = [4, 5, 7, 8, 0, 1, 2]
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 如果数字可以重复，那么要多加上一个情况，
            // if (array[left] == array[mid]) {left++;} 来继续缩小范围
            // worst case: [3,3,3,1,3]需要O(n)的时间排除
            else if (nums[mid] >= nums[left]) {// 说明是左半段上坡
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else { // nums[mid] < nums[left] 说明已经掉到下坡了
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1; // 因为target != nums[mid] 所以可以+1 但是if()里面不可以只是> or < !! 会漏掉正确答案
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}