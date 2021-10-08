package DPII;

public class LA101_LC221_MaximalSquareOf1 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int globalMaxSide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                }
                else if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    //  globalMaxSide = Math.max(globalMaxSide, dp[i][j]);
                }
                // update全局变量也要考虑只有第一个if()的情况，比如只有i=0/j=0
                globalMaxSide = Math.max(globalMaxSide, dp[i][j]);
            }
        }
        return globalMaxSide * globalMaxSide;
    }
}
