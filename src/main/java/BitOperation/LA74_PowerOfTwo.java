package BitOperation;

public class LA74_PowerOfTwo {
    // 2的N次方的特点：1000000000
    //  如果每次&1==0，那么保持循环，每次右移一位再&1，最后得到的结果应该==1
    //  如果每次&1得到1个count，然后循环，每次右移一位，最后count应该==1
    //  N & (N-1) == 0
    public boolean isPowerOfTwo(int number) {
        if (number <= 0) {
            return false;
        }
        int count = 0;
        while (number > 0) {
            count += number & 1;
            number = number >>> 1;
        }
        return count == 1;
    }
    public boolean isPowerOfTwo2(int number) {
        if (number <= 0) {
            return false;
        }
        return (number & (number - 1)) == 0;
    }

}
