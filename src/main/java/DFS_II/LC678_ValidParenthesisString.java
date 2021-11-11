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
}
