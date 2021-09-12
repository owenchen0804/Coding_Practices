package DFS_I;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LA179_ValidParenthesisII {
    //  这道题的要求是如果要加上右括号，那么一定要和前面一个位置的括号匹配，比如()<> or <()> 很容易想到stack这个
    //  额外的DS来看看每次栈顶是哪个符号
    private static final char[] PS = new char[] {'(', ')', '<', '>', '{', '}'};

    public List<String> validParenthesisII(int l, int m, int n) {
        int[] remain = {l, l, m, m, n, n};
        int targetLen = 2 * (l + m + n);
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        //  stack里面只存左括号！！
        helper(remain, targetLen, sb, stack, result);
        return result;
    }

    private void helper(int[] remain, int targetLen, StringBuilder sb, Deque<Character> stack, List<String> result) {
        if (sb.length() == targetLen) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {   //  针对所有左括号而言
                if (remain[i] > 0) {
                    sb.append(PS[i]);
                    stack.offerFirst(PS[i]);
                    remain[i]--;
                    helper(remain, targetLen, sb, stack, result);
                    //  退到上一层
                    sb.deleteCharAt(sb.length() - 1);
                    remain[i]++;
                    stack.pollFirst();
                }
            }
            else {  //  加右括号，且要和左边括号的种类match的上
                if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {   //  注意stack不为空！
                    sb.append(PS[i]);
                    stack.pollFirst();
                    remain[i]--;
                    helper(remain, targetLen, sb, stack, result);
                    //  返回上一层
                    sb.deleteCharAt(sb.length() - 1);
                    remain[i]++;
                    stack.offerFirst(PS[i - 1]);
                }
            }
        }
    }
}
