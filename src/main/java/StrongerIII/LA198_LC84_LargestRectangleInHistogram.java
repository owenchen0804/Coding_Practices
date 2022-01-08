package StrongerIII;

public class LA198_LC84_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= heights.length; i++) {
            // 如果index到最后了就把高度设为0，根据算法这是最小的，进入清算阶段
            int curr = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peekFirst()] >= curr) {
                // 如果当前的curr比较小，则需要进入清算
                int height = heights[stack.pollFirst()]; // 定出来高度
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1; // 这里peek的是上一个，需要+1
                result = Math.max(result, height * (i - left));
            }
            stack.offerFirst(i);
        }
        return result;
    }
}
