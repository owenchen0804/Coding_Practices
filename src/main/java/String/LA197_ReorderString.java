package String;

//  为了保证chunk 1 and chunk 3的size相等，也就是原来的chunk2换到chunk3之后的size和chunk 1相等
//  因此mid = left + size / 2，而不是left + (right - left)/2，比如8个元素，前者会到index = 4
//  后者是index = 3，因为right -left = 7 - 0
//  注意算lmid, mid, rmid的时候都可以从left出发，这样不容易错
//  递归的时候两个helper()里面的坐标要写对，不然很容易错，比如不要自己先心算了size/4*2就是size/2
//  比如size=14, size/4 * 2应该是6而不是7.

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
