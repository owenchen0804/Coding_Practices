package StrongerI;

public class LA125_RotateMatrix {
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) {
            return;
        }
        for (int offset = 0; offset < n / 2; offset++) {
            // 左边起始left + offset, 右边终点为 n - 2 - offset 相当于减掉2
            int left = offset, right = n - 2 - offset; // right取不到最后一个，只取到倒数第二个
            for (int i = left; i <= right; i++) {
                int temp = matrix[left][i];
                matrix[left][i] = matrix[n - 1 - i][left];
                matrix[n - 1 - i][left] = matrix[n - 1 - left][n - 1 - i];
                matrix[n - 1 - left][n - 1 - i] = matrix[i][n - 1 - left];
                matrix[i][n - 1 - left] = temp;
            }
        }
    }
}
