package BinarySearch;

public class FindMatrix {
    public int[] findMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }
        int M = matrix.length, N = matrix[0].length;
        int left = 0, right = M * N - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / M][mid % N] == target) {
                return new int[mid / M, mid % N];
            }
            if (matrix[mid / M][mid % N] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return new int[] {-1, -1};
    }
}