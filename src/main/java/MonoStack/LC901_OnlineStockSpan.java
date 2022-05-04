package MonoStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC901_OnlineStockSpan {
    // You can refer to the same problem 739. Daily Temperatures.

    // Push every pair of <price, result> to a stack.
    // Pop lower price from the stack and accumulate the count.

    // One price will be pushed once and popped once.
    // So 2 * N times stack operations and N times calls.
    // I'll say time complexity is amortized O(1)
    Deque<int[]> stack;
    public LC901_OnlineStockSpan() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int result = 1; // 自带1，没有比自己小的就是自己
        while (!stack.isEmpty() && stack.peekFirst()[0] <= price) {
            result += stack.pollFirst()[1];
        }
        stack.offerFirst(new int[]{price, result});
        return result;
    }
}
