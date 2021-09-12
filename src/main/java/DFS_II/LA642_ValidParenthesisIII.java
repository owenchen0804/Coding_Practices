package DFS_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LA642_ValidParenthesisIII {
    private static final char[] PS = new char[] {'(', ')', '<', '>', '{', '}'};
    public List<String> validParenthesisIII(int l, int m, int n) {
        List<String> result = new ArrayList<>();
        int[] remain = new int[] {l , l, m, m, n, n};
        int targetLen = 2 * (l + m + n);
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();  // 这里只能用i的坐标比较优先级，i越大优先级越高
        helper(remain, stack, sb, targetLen, result);
        return result;
    }

    private void helper(int[] remain, Deque<Integer> stack, StringBuilder sb,
                        int targetLen, List<String> result) {
        if (sb.length() == targetLen) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {
                if (remain[i] > 0 && (stack.isEmpty() || stack.peekFirst() > i)) {
                    sb.append(PS[i]);
                    remain[i]--;
                    stack.offerFirst(i);
                    helper(remain, stack, sb, targetLen, result);

                    sb.deleteCharAt(sb.length() - 1);
                    remain[i]++;
                    stack.pollFirst();
                }
            }
            else {
                if (!stack.isEmpty() && stack.peekFirst() == i - 1) {
                    sb.append(PS[i]);
                    remain[i]--;
                    stack.pollFirst();
                    helper(remain, stack, sb, targetLen, result);

                    sb.deleteCharAt(sb.length() - 1);
                    remain[i]++;
                    stack.offerFirst(i - 1);
                }
            }
        }
    }
}
