package Probability;

public class LA108_PerfectShuffle {
    public void shuffle(int[] array) {
        // Write your solution here.
        if (array.length <= 1) {
            return;
        }
        for (int i = array.length; i >= 1; i--) {
            // 因为是要perfect shuffle，所以每次的选取区间应该要减小，最开始的选择区间应该是array.length = N
            //  个，而不是从array.length - 1 到 0，应该从N到1
            int idx = (int) (Math.random() * i);
            int temp = array[i - 1];
            array[i - 1] = array[idx];
            array[idx] = temp;
        }
    }
}
