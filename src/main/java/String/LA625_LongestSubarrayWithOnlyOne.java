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
                k++;
                //  注意！这里的意思是如果slow对应的是0，那么slow++后可以多出来一个0的quota，所以k++
                //  但是！如果nums[slow]还是1的话，花括号的里面不执行，但是！圆括号里面slow还是会++的。
            }
            //  如果不太理解上述写法的话可以再加一个
            //  else {
            //      slow++;
            //  }
            //  前面要改成if (nums[slow] == 0)

        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,1};
        LA625_LongestSubarrayWithOnlyOne test = new LA625_LongestSubarrayWithOnlyOne();
        System.out.println(test.longestOnes(nums, 0));
        int count = 0;
        int slow = 0;
        while (slow < 3) {
            if (nums[slow++] == 0) {
                count++;
            }
        }
        System.out.println(slow);
    }
}
