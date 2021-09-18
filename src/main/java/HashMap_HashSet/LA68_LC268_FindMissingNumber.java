package HashMap_HashSet;

public class LA68_LC268_FindMissingNumber {
    public int missingI(int[] array) {
        if (array.length == 0) {
            return 1;
        }
        for (int i = 0; i < array.length; i++) {
            //  里面的while循环保证了换到i的一定是i+1，或者是array.length + 1
            //  比如array = {6,2,3,4,5} 那么发现array[0] = array.length + 1就停止继续while循环
            //  因为6不在任何"该在"的index上，不会影响别的index，所以是OK的
            while (array[i] != i + 1 && array[i] != array.length + 1) {
                // 只要没换到我想要的就继续一直换，但实际的总时间最多还是O(n)
                swap(array, i, array[i] - 1);   // array[i] - 1的index取值范围正好是从0到array.length - 1
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1) {
                return i + 1;
            }
        }
        //  如果index = 0 --- array.length - 1都in place了只剩最后一个数了
        return array.length + 1; // 比如{1,2,3,4,5} 缺的是6

    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public int missingII(int[] array) {
        // 利用xor异或的交换和结合律 1^2^3^1^3 = (1^1) ^ (3^3) ^ 2 = 0 ^ 0 ^ 2 = 2;
        int n = array.length + 1;
        int xor = 0;
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        for (int num : array) {
            xor ^= num;
        }
        return xor;
    }
}
