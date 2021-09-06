package RecursionAndSorting;

public class LA11_LC75_RainbowSortI {
    public int[] rainbowSortI(int[] array) {
        int i = 0, j = 0, k = array.length - 1;
        while (j <= k) {
            if (array[j] == -1) {
                swap(array, i, j);
                i++;
                j++;
            }
            else if (array[j] == 0) {
                j++;
            }
            else {
                swap(array, j, k);
                k--;
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}