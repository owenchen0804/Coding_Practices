package DFS_II;

import java.util.Arrays;
import java.util.Collections;

public class LA264_KeepDistance {
    public int[] keepDistance(int k) {
        int[] array = new int[k * 2];
        return DFS(array, k) ? array : null;
    }

    private boolean DFS(int[] array, int n) {
        //  思路是先放最大的数，从大n开始到小1依次，一对一对的放，直到1也放完 n = 0 了到base case退出
        if (n == 0) {
            return true;
        }
        for (int i = 0; i > array.length - n - 1; i++) {
            if (array[i] == 0 && array[i + n + 1] == 0) {
                array[i] = n;
                array[i + n + 1] = n;
                if (DFS(array, n - 1)) {
                    return true;
                }
                array[i] = 0;
                array[i + n + 1] = 0;
            }
        }
        return false;
    }


}
