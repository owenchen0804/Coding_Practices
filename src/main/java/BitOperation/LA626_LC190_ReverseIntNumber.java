package BitOperation;

public class LA626_LC190_ReverseIntNumber {
    public int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            int left = (n >>> (31 - i)) & 1;
            int right = (n >>> i) & 1;
            if (left != right) {
                //  要注意这里的最高位，比如i=0的时候1需要左移31位，超过了int的表示范围，可能会被迫丢弃
                //  只有先cast为long型的才能保证最高位不会丢失
                n ^= 1L << (31 - i);
                n ^= 1 << i;
            }
        }
        return n;
    }
}
