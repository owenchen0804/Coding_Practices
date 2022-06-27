package BinarySearch;

public class LC540_SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        //  注意观察规律：index为奇数的时候如果没有漏掉数字那么nums[index] == nums[index+1]
        //  如果index是偶数，则应该和它之前的数字相等，如果不等，就说明前面的出了问题
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            //  万用套路模板，一定会在还有2个或者1个元素的时候退出
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    //  如果和后面那个相等，说明左半部分没问题，直接跳过mid + 1
                    left = mid + 2;
                }
                else {
                    right = mid;
                }
            }
            else {
                if (nums[mid] == nums[mid - 1]) {
                    //  如果和之前那个相等，也说明左半部分没问题，可以跳过当前的mid了
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }
        }
        return nums[left];  //  最后甭管剩1个还是2个，都是要和nums[left]那个缺省的一样
    }
}
