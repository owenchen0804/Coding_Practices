package StrongerIV;

public class LA206_LC169_MajorityElement {
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                result = nums[i];
            }
            else if (nums[i] == result) {
                count++;
            }
            else {
                count--;    // 类似火并双死
            }
        }
        return result;
    }
}
