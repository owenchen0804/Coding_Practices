package DPIII;

public class LA638_LargestSquareOfMatches {
    public int largest(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] right = new int[N][M];
        int[][] down = new int[N][M];
        int result = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (hasRight(matrix[i][j])) {
                    right[i][j] = getNumber(right, i, j + 1, N, M) + 1;
                }
                if (hasDown(matrix[i][j])) {
                    down[i][j] = getNumber(down, i + 1, j, N, M) + 1;
                }
                if (hasBoth(matrix[i][j])) {
                    for (int side = Math.min(right[i][j], down[i][j]); side > 0; side--) {
                        if (right[i][j + side - 1] >= side && down[i + side - 1][j] >= side) {
                            result = Math.max(side, result);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    private int getNumber(int[][] matrix, int x, int y, int N, int M) {
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return 0;
        }
        return matrix[x][y];
    }

    private boolean hasRight(int value) {
        return (value & 0b1) != 0;
    }

    private boolean hasDown(int value) {
        return (value & 0b10) != 0;
    }

    private boolean hasBoth(int value) {
        return value == 0b11;
    }
}
