package Contest;

public class LC2373_LargestLocalValuesInAMatrix {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                result[i][j] = findMax(grid, i, j);
            }
        }
        return result;
    }

    private int findMax(int[][] grid, int row, int col) {
        int max = 1;
        for (int i = row; i <= row + 2; i++) {
            for (int j = col; j <= col + 2; j++) {
                max = Math.max(grid[i][j], max);
            }
        }
        return max;
    }
}
