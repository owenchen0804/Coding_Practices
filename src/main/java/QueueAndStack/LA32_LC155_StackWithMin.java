public class LA32_LC155_StackWithMin {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public LA32_LC155_StackWithMin() {
        stack = new ArrayDeque<Integer>();
        minStack = new ArrayDeque<Integer>();
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int result = stack.pollFirst();
        //  这里不可能为空，因为只要stack里面有数字，那么minStack肯定不会为空，放第一个数字的时候minStack也要进去
        //  if (!minStack.isEmpty() && result == minStack.peekFirst()) {
            if (minStack.peekFirst() == result) {
            minStack.pollFirst();
        }
        return result;
    }

    public void push(int element) {
        stack.offerFirst(element);
        if (minStack.isEmpty() || element <= minStack.peekFirst()) {
            minStack.offerFirst(element);
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peekFirst();
    }

    public int min() {
        return minStack.isEmpty() ? -1 : minStack.peekFirst();
    }
}