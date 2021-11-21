package DFS_II;

public class LC678_ValidParenthesisString {
    public boolean checkValidString(String s) {
        return DFS(s, 0, 0);
    }

    private boolean DFS(String s, int index, int left) {
        if (index == s.length()) {
            return left == 0;
        }
        char c = s.charAt(index);
        if (c == '(') return DFS(s, index + 1, left + 1);
        else if (c == ')') {
            if (left == 0) {
                return false;
            }
            return DFS(s, index + 1, left - 1); // 表示左括号被消掉了1个
        }
        else {  // c只能是*
            if (DFS(s, index + 1, left + 1)) {  // c当做(
                return true;
            }
            else if (DFS(s, index + 1, left)) { //  c当做nothing
                return true;
            }
            else if (left > 0 && DFS(s, index + 1, left - 1)) { // c当做右括号，但前提是还有(左括号
                return true;
            }
            else {
                return false;
            }
        }
    }

    public boolean checkValidString2(String s) {
        //  lo 代表了左括号最小能是多少，只要c != ( 就可以- 1
        //  hi 代表了左括号最大能是多少，只要c != ) 就可以+ 1
        //  全过程不能hi < 0 那就违背了题意，出现hi < 0说明一定当前)多于(，返回
        //  到最后的时候lo一定要为0，如果lo > 0 说明还是由左括号消除不掉，也不valid
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            lo += (c == '(') ? 1 : -1;
            hi += (c == ')') ? -1 : 1;
            if (hi < 0) {
                return false;
            }
            lo = Math.max(lo, 0);   // 比如一开始是* lo = -1，但还是当0处理
        }
        return lo == 0;
    }
}
