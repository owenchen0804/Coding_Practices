public class LA400_RainbowSortIII {
    // Method 1 通过count sort的方法
    public int[] countSort(int[] array, int k) {
        int[] count = new int[k];
        for (int i : array) {   // 比如i = 2，那么对应count[1]这个value就应该++
            count[i - 1]++;
        }
        int index = 0;
        for (int i = 0; i < k; i++) {
            while(count[i] > 0) {
                array[index] = i + 1;
                index++;
                count[i]--;
            }
        }
        return array;
    }

    // Method 2 两头先排序，再往中间凑
    int left = 0, right = array.length - 1;
    for (int round = 1; round <= k / 2; round++) {
        int leftColor = round;
        int rightColor = k + 1 - round;
        //  int i = left, j = right;
        for (int i = left; i <= right; i++) {
            if (array[i] == leftColor) {
                swap(array, i, left);
                left++;
            }
            else if (array[i] == rightColor) {
                swap(array, i, right);
                right--;
                i--;
            }
        }
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}