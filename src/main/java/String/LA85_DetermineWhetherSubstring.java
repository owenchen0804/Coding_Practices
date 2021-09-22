package String;

public class LA85_DetermineWhetherSubstring {
    public int determineI(String s1, String s2) {    //  看s2是否是s1的substring
        if (s1 == null || s2 == null || s1.length() < s2.length()) {
            return -1;
        }
        if (s2.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s1.length() - s2.length(); i++) {
            int j = 0;
            while (j < s2.length() && s1.charAt(i + j) == s2.charAt(j)) {
                j++;
            }
            if (j == s2.length()) {
                return i;
            }
        }
        return -1;
    }

    public int determineII(String s1, String s2) {    //  看s2是否是s1的substring
        if (s1 == null || s2 == null || s1.length() < s2.length()) {
            return -1;
        }
        if (s2.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s1.length() - s2.length(); i++) {
            if (equal(s1, i, s2)) {
                return i;
            }
        }
        return -1;
    }

    private boolean equal(String s1, int start, String s2) {
        for (int j = 0; j < s2.length(); j++) {
            if (s1.charAt(j + start) != s2.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
