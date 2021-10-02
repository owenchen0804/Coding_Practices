package RecursionII;

public class LA292_StringAbbreviationMatching {
    public boolean match(String input, String pattern) {
        return helper(input, pattern, 0, 0);
    }

    private boolean helper(String s, String t, int si, int ti) {
        if (si == s.length() && ti == t.length()) {
            return true;
        }
        if (si >= s.length() || ti >= t.length()) {
            //  可能没匹配上但是si/ti到字符串终点了，或者甚至超过了终点，都应该停止
            return false;
        }
        if (t.charAt(ti) < '0' || t.charAt(ti) > '9') {
            //  case 1. not a digit
            if (t.charAt(ti) == s.charAt(si)) {
                return helper(s, t, si + 1, ti + 1);
            }
            return false;   //  不相等的话可以early return了
        }
        //  case 2. if the current char is digit, need to count how many
        int count = 0;
        while (ti < t.length() && t.charAt(ti) >= '0' && t.charAt(ti) <= '9') {
            count = count * 10 + (t.charAt(ti) - '0');
            ti++;
        }
        return helper(s, t, si + count, ti);
    }
}
