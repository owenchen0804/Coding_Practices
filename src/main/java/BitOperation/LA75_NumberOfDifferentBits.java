package BitOperation;

public class LA75_NumberOfDifferentBits {
    public int differentBits(int a, int b) {
        a = a ^ b;
        int count = 0;
        while (a != 0) { // a 不一定要 >0, 可以是负数，最后终止条件应该是 == 0
            count += a & 1;
            a >>>= 1;
        }
        return count;
    }
}
