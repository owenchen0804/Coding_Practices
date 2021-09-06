package BinarySearch;

public class LC240_Search2DMatrix {
    //  matrix是从左往右递增，从上往下递增
    //  出发点可以设为右上角，value < target肯定往下走，> target肯定往左走
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                row++;
            }
            else {
                col--;
            }
        }
        return false;
    }
}