package DPII;

public class LA100_LC72_EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return word1.length() == 0 ? word2.length() : word1.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //  先定义好了边界的值
        for (int i = 0; i <= word1.length(); i++) {
            //  word1放在row的位置
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            //  把word2放在column的位置
            dp[0][j] = j;
        }
        //  上面两个for循环可以合并写入下面这个for/for循环！
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
