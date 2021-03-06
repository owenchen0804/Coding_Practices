package StrongerI;

public class LA119_LargestAndSmallest {
    public int[] largestAndSmallest(int[] array) {
        //  assumption: array is not null && array.length > 1;
        int N = array.length;
        for (int i = 0; i < N / 2; i++) {
            if (array[i] < array[N - 1 - i]) {
                swap(array, i, N - 1 - i);
            }
        }
        //  两两比较且swap，把胜者组放在前半段，败者组放在后半段，再各自找winner/loser
        //  这样的比较次数最少，前面分出胜败组是n/2,然后算上下面各比较n/2，一共3n/2
        //  如果直接O(n)的循环比较，就是2n, > 3n/2
        int largest = array[0];
        for (int i = 1; i < N / 2; i++) {
            largest = Math.max(largest, array[i]);
        }

        int smallest = array[N / 2];
        for (int i = N / 2; i < N; i++) {
            smallest = Math.min(smallest, array[i]);
        }
        return new int[] {largest, smallest};
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
