package DFS_I;

import java.util.ArrayList;
import java.util.List;

public class LA66_LC22_ValidParenthesisI {
    public List<String> validParenthesis(int k) {
        List<String> result = new ArrayList<>();
        if (k <= 0) {
            return result;
        }
        char[] cur = new char[k];
        helper(cur, k, k, 0, result);
        return result;
    }

    private void helper(char[] cur, int l, int r, int index, List<String> result) {
        if (l == 0 && r == 0) {
            //  result.add(cur.toString());
            result.add(new String(cur));
            return;
        }
        if (l > 0) {//  只要左括号还有(
            cur[index] = '(';
            helper(cur, l - 1, r, index + 1, result);
            // 可以不需要🤮，原因:
            //  1. we are setting the character at index and when back tracking, what we need
            //  is just 1). remove the character at index and 2). add a different character at index

            //  2. only when we fill in all the positions in cur, we have a complete solution.
            //  The code itself actually already suffices the above two points and it already
            //  does the correct removing operation when back tracked to the previous level

            //  简单来说就是这里负责吃的是char[] array，所以退回去back track不需要吐，下次进来再吃的时候可以
            //  overwrite覆盖掉之前吃进去的，所以没什么问题。

        }
        if (r > l) {    // 只有左括号多余右括号，也就是还剩下的r > l才能添加右括号
            cur[index] = ')';
            helper(cur, l, r - 1, index + 1, result);
        }
    }
}
