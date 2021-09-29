package RecursionII;

import java.util.List;

public class LA121_LC59_SpiralMatrixI {
    public int[][] generateMatrix(int n) {
        //  这里是正方形的矩阵，所以其实可以合并left/up as start, right/down as end
        //  且不用担心left超过right或者up超过down，不需要下面2个if的判定
        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }
        int left = 0, up = 0;
        int right = n - 1, down = n - 1;
        int num = 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                result[up][i] = num++;
            }
            up++;
            for (int i = up; i <= down; i++) {
                result[i][right] = num++;
            }
            right--;
            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    result[down][i] = num++;
                }
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    result[i][left] = num++;
                }
                left++;
            }
        }
        return result;
    }
}
