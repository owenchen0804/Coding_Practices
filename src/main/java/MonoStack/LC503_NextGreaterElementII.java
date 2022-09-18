package MonoStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 1) {
            return new int[] {-1};
        }
        //  Use monostack, and it stores the index of number, decreasingly
        //  When a new number comes, if it is larger, will need to pop the stack, and
        //  also the NGE index is determined to the poped index
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> monoStack = new ArrayDeque<>();
        int len = nums.length;
        for (int i = 0; i < len * 2; i++) {
            //  题目要求是circular找，所以i的取值范围是2 * len
            while (!monoStack.isEmpty() && nums[monoStack.peekFirst()] < nums[i % len]) {
                //  如果来的更大了说明找到了NGE，要Pop出来，否则就是单调递减的存着
                int index = monoStack.pollFirst();
                result[index] = nums[i % len];
            }
            //  otherwise just offer the number
            monoStack.offerFirst(i % len);
        }
        return result;
    }
}
