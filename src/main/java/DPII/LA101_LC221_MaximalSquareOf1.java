package DPII;

public class LA101_LC221_MaximalSquareOf1 {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        //  dp[i][j]表示在以matrix[i][j]为右下角的矩形当中最长的为1的边是多少
        int globalMaxSide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                    //  在第0行和第0列的dp[][]值就是看对应matrix[][]上的值，是1就是1,0就是0
                }
                else if (matrix[i][j] == '1') {
                    //  只有当matrix[][] = 1的时候才有必要看，不然右下角这个是0的话没必要再看
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    //  globalMaxSide = Math.max(globalMaxSide, dp[i][j]);
                }
                // update全局变量也要考虑只有第一个if()的情况，比如只有i=0/j=0
                globalMaxSide = Math.max(globalMaxSide, dp[i][j]);
            }
        }
        return globalMaxSide * globalMaxSide;
    }
    // 空间可以继续优化，因为每个dp[i][j]只取决于它前一个，左上方一个，和上方一个，所以实际上只需要2行就够了
    // int[][] dp = new int[2][n];
    //  for (int col = 0; col < n; col++) {
    //      dp[0][col] = matrix[0][col];    //  先把第一行填了，具体值和matrix[0][]完全一样
    //  }
    //  for (int i = 1; i < m; i++) {
    //      dp[i][0] = matrix[i][0];    //  每一行的第一个也和matrix[][0]一致
    //      for (int j = 1; j < n; j++) {
    //          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
    //      }
    //  }

    public int largest(int[][] matrix) {
        // Write your solution here
        int[][] m = new int[2][matrix[0].length];
        int globalMax = 0;


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (i == 0 || j == 0) {
                    m[i % 2][j] = matrix[i][j];
                } else if(matrix[i % 2][j] == 0) {
                    m[i % 2][j] = 0;
                } else {
                    m[i % 2][j] = Math.min(m[(i - 1) % 2][j - 1],
                            Math.min(m[i % 2][j - 1], m[(i - 1) % 2][j])) + 1;
                }
                globalMax = Math.max(globalMax, m[i % 2][j]);
            }
        }
        return globalMax;
    }

}
