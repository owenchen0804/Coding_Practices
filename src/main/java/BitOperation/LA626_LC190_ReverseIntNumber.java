package BitOperation;

public class LA626_LC190_ReverseIntNumber {
    public int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            int left = (n >>> (31 - i)) & 1;
            int right = (n >>> i) & 1;
            if (left != right) {
                n ^= 1 << (31 - i);
                n ^= 1 << i;
            }
        }
        return n;
    }
}
