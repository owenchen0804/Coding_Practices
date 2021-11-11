package DFS_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LA179_AllValidPermutationsOfParenthesesII {
    private static final char[] PS = {'(', ')', '<', '>', '{', '}'};
    public List<String> validParentheses(int l, int m, int n) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        int[] remain = {l, l, m, m, n, n};
        int targetLen = 2 * (l + m + n);
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        DFS(remain, targetLen, sb, stack, result);
        return result;
    }

    private void DFS(int[] remain, int targetLen, StringBuilder sb, Deque<Character> stack, List<String> result) {
        if (sb.length() == targetLen) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {
                if (remain[i] > 0) {
                    sb.append(PS[i]);
                    remain[i]--;
                    stack.offerFirst(PS[i]);
                    DFS(remain, targetLen, sb, stack, result);
                    sb.deleteCharAt(sb.length() - 1);
                    remain[i]++;
                    stack.pollFirst();
                }
            }
            else {
                // 必须stack不能为空，且正好此时的i的左半边正好对应上stack.peekFirst()!!
                if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
                    sb.append(PS[i]);
                    remain[i]--;
                    stack.pollFirst();
                    DFS(remain, targetLen, sb, stack, result);
                    sb.deleteCharAt(sb.length() - 1);
                    remain[i]++;
                    stack.offerFirst(PS[i - 1]);
                }
            }
        }
    }
}
