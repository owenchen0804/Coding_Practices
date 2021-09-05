public class LA10_QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        //  应该把random的操作放到partition() method里面, pivot这个随机Index也是在partition()里面生成的
        //  rand = new Rand();
        // int random = rand.nextInt(right - left + 1) + left;
        //  int pivotIndex = partition(array, left, right, random);
        int pivotIndex = partition(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        // all the numbers that <= pivot should be on the left, the rest on the right
        Random rand = new Random();
        int pivot = rand.nextInt(right - left + 1) + left;  // .nextInt(value)的范围是[0, value);
        int i = left, j = right - 1;
        swap(array, pivot, right);
        while (i <= j) {
            if (array[i] <= array[pivot]) {
                i++;
            }
            else if (array[j] > array[pivot]) {
                j--;
            }
            else {
                swap(array, i++, j--);
            }
        }
        swap(array, i, right);
        return i;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}