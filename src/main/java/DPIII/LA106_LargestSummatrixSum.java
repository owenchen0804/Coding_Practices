package DPIII;

public class LA106_LargestSummatrixSum {
    public int largest(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int result = Integer.MIN_VALUE;
        for (int i1 = 0; i1 < N; i1++) {    // 顶天
            int[] cur = new int[M]; // 这个数组的size = column number
            for (int i2 = i1; i2 < N; i2++) {   //  立地
                add(cur, matrix[i2]);
                result = Math.max(result, max(cur));
            }
        }
        return result;
    }

    private void add(int[] cur, int[] array) {
        for (int i = 0; i < cur.length; i++) {
            cur[i] += array[i];
        }
    }

    private int max(int[] array) {
        int largest = array[0];
        int lastMax = array[0];
        for (int j = 1; j < array.length; j++) {
            lastMax = Math.max(array[j], lastMax + array[j]);
            largest = Math.max(lastMax, largest);
        }
        return largest;
    }

}
