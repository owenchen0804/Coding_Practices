package String;

public class LA625_LongestSubarrayWithOnlyOne {
    public int longestOnes(int[] nums, int k) {
        int slow = 0, fast = 0, longest = 0;
        while (fast < nums.length) { // 这里的longest要先让fast++然后再减去slow，所以只能用while而不是for
            if (nums[fast] == 1) {
                longest = Math.max(longest, ++fast - slow); // 注意当前subarray的长度是fast移动一位后再减去slow
                //  sliding window的大小一定是两个坐标之间的关系
            } else if (k > 0) {
                longest = Math.max(longest, ++fast - slow);
                k--;
            } else if (nums[slow++] == 0) {
                k++;   // 这里的意思是如果slow对应的是0，那么slow++后可以多出来一个0的quota，所以k++
                // 但是如果nums[slow]还是1的话，括号里面不执行，但是！ slow还是会++的。
            }
            //  不太理解上述写法的话可以再加一个
            //   else {
            //      slow++;
            //   }

        }
        return longest;
    }
}
