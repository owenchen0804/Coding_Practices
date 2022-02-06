package DPIV;

public class LA177_LC1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        //  char[] t1 = text1.toCharArray();
        //  char[] t2 = text2.toCharArray();
        //  int longest = 0;
        int[][] longest = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                //  不是像substring那样只关心当t1[i] = t2[j]的情况，其他默认都是0
                //  这里的逻辑是如果相等，那么是左上角+1，如果不相等，则是=左边和上边更大的那个！
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    longest[i][j] = longest[i - 1][j - 1] + 1;
                }
                else {
                    longest[i][j] = Math.max(longest[i - 1][j], longest[i][j - 1]);
                }
            }
        }
        return longest[text1.length()][text2.length()];
    }
}
