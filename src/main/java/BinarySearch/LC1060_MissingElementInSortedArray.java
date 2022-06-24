package BinarySearch;

public class LC1060_MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        //  we can find the first occurence of alreadyMissing >= k (or last occ. < k)
        //  如果没有missing，那么当前的nums[i] = nums[0] + i;
        //  那么miss的个数 = nums[mid] - nums[0] - mid;
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int alreadyMissing = nums[mid] - nums[0] - mid;
            if (alreadyMissing < k) {
                left = mid + 1; // 要找first occurence，小于k的肯定可以排除
            }
            else {
                right = mid;
            }
        }
        if (nums[left] - left - nums[0] >= k) {
            return nums[0] + k + left - 1;
        }
        if (nums[right] - right - nums[0] >= k) {
            return nums[0] + k + right - 1;
        }

        //  要考虑到一直没有 >= k 的情况，这时候right已经到最后一个index了
        // if (nums[right] < nums[0] + right + k) {
        return nums[0] + right + k;
        // }

        // return -1;   //  不可能有-1的情况，因为一切都是根据nums[0]开始的
    }
}
