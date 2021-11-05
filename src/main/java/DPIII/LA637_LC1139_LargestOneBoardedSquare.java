package DPIII;

public class LA637_LC1139_LargestOneBoardedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int[][] left = new int[N][M];
        int[][] up = new int[N][M];
        int maxSide = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    left[i][j] = getNumber(left, i, j - 1, N, M) + 1;
                    up[i][j] = getNumber(up, i - 1, j, N, M) + 1;
                    for (int side = Math.min(left[i][j], up[i][j]);
                         side > 0; side--) {
                        if (left[i - side + 1][j] >= side && up[i][j - side + 1] >= side) {
                            maxSide = Math.max(maxSide, side);
                            break;
                        }
                    }
                }
            }
        }
        return maxSide * maxSide;

    }
    //  和之前一样，还是可以用getNumber helpoer method来处理边界情况
    private int getNumber(int[][] matrix, int x, int y, int N, int M) {
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return 0;
        }
        return matrix[x][y];
    }
}
