package com.owen.Coding_Practices;

import java.util.ArrayList;
import java.util.List;

public class ParenthesisTest {

    public List<String> validParentheses(int n) {
        List<String> res = new ArrayList<>();
        int l = n;
        int r = n;
        char[] oneCase = new char[2 * n];
        helper(res, oneCase, 0, l, r);
        return res;
    }

    private void helper(List<String> res, char[] oneCase, int index, int l, int r) {
        if (l == 0 && r == 0) {
            res.add(new String(oneCase));
            return;
        }
        if (l > 0) {
            oneCase[index] = '(';
            l = l - 1;
            helper(res, oneCase, index + 1, l, r);
            // 错误❌ 这样写l就永远变成l - 1了，弹栈的时候l就不会变成原来的l了。
        }
        if (r > l) {
            oneCase[index] = ')';
            r = r - 1;
            helper(res, oneCase, index + 1, l, r);
        }
    }
    public static void main(String[] args) {
        ParenthesisTest test = new ParenthesisTest();
        System.out.println(test.validParentheses(2));
    }
}
