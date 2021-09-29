package RecursionII;

import java.util.ArrayList;
import java.util.List;

public class LA122_LC54_SpiralMatrixII {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 这里matrix是m*n的，m和n不一定相等。
        // 在做完了第1&2个for循环后，注意要判断一下才能做3&4个for循环
        // 否则，比如m = 3, n = 1 => [[3], [6], [9]] 如果没有if判断，虽然第三个for不执行，但是down--后会执行
        // 第四个for，然后会重复打印[6]出来
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int left = 0, up = 0;
        int down = matrix.length - 1;
        int right = matrix[0].length - 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (up <= down) {
                for (int i = right; i>= left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
