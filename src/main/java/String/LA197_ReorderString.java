package String;

public class LA197_ReorderString {
    //  ABCD1234 -> 找到中间的两段分别反转 -> AB DC 21 34 -> 中间2段整体反转 -> AB 12 CD 34 -> 同样的逻辑可以得到 A1B2C3D4
    public int[] stringShuffle(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        if (array.length % 2 == 0) {
            helper(array, 0, array.length - 1);
        }
        else {
            helper(array, 0, array.length - 2);
        }
        return array;
    }

    private void helper(int[] array, int left, int right) {
        int length = right - left + 1;
        if (length <= 2) {
            return;
        }
        // 0 1 2 3 4 5 6 7
        // lm:2, m:4, rm: 6
        // 0 1 2 3 4 5 6 7 8 9
        // lm:2, m:5, rm:7
        // chunk1: [left, lm-1] [0,1]
        // chunk2: [lm, m-1]    [2,3,4]
        // chunk3: [m, rm-1]    [5,6]
        // chunk4: [rm, right]  [7,8,9]
        // 要保证chunk1 & chunk3的size一致
        int mid = left + length / 2;
        int lmid = left + length / 4;
        int rmid = left + length * 3 / 4;
        reverse(array, lmid, mid - 1);
        reverse(array, mid, rmid - 1);
        reverse(array, lmid, rmid - 1);
        helper(array, left, left + (lmid - left) * 2 - 1);
        helper(array, left + (lmid - left) * 2, right);
    }
    private void reverse(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
