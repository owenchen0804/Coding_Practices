package DPIII;

public class LA105_LargestXOfOnes {
    public int largest(int[][] matrix) {
        // Write your solution here
        int N = matrix.length;
        if (N == 0) {
            return 0;
        }
        int M = matrix[0].length;
        if (M == 0) {
            return 0;
        }
        int[][] leftUp = leftUp(matrix, N, M);
        int[][] rightDown = rightDown(matrix, N, M);
        // 这个X拆分开来，先看左上和右上，因为对于i而言是要看i - 1的
        // 同理X后看左下和右下，所以要逆序for循环，由i+1得到i
        return merge(leftUp, rightDown, N, M);
    }

    private int getNumber(int[][] matrix, int x, int y, int N, int M) {
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return 0;
        }
        return matrix[x][y];
    }

    private int merge(int[][] leftUp, int[][] rightDown, int N, int M) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
                result = Math.max(result, leftUp[i][j]);
            }
        }
        return result;
    }

    private int[][] leftUp(int[][] matrix, int N, int M) {
        int[][] left = new int[N][M];
        int[][] up = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    left[i][j] = getNumber(left, i - 1, j - 1, N, M) + 1;
                    //  注意这里都是针对dp[][]自己来getNumber的，而不是原来的input matrix
                    up[i][j] = getNumber(up, i - 1, j + 1, N, M) + 1;
                }
            }
        }
        merge(left, up, N, M);
        return left;
    }

    private int[][] rightDown(int[][] matrix, int N, int M) {
        int[][] right = new int[N][M];
        int[][] down = new int[N][M];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    right[i][j] = getNumber(right, i + 1, j - 1, N, M) + 1;
                    down[i][j] = getNumber(down, i + 1, j + 1, N, M) + 1;
                }
            }
        }
        merge(right, down, N, M);
        return right;
    }
}
