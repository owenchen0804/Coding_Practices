package StrongerI;

public class LA120_LC1464_LargestAndSecondLargest {
    public int[] largestAndSecond(int[] array) {
        // Write your solution here
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max1) {
                max2 = max1;
                max1 = array[i];
                //  注意顺序！要先把max1赋值给max2!
            }
            else if (array[i] > max2) {
                max2 = array[i];
            }
        }
        return new int[] {max1, max2};

    }

}
