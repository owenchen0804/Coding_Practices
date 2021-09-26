package BitOperation;

public class LC7_ReverseInteger {
    public int reverse(int x) { // input and output has to be int 所以要考虑是否可能会overflow!!
        int result = 0;
        while (x != 0) {
            int temp = x % 10;
            int newResult = result * 10 + temp; // 每次拿到最后一位
            if ((newResult - temp) / 10 != result) {
                // overflow的时候newResult可能变成很大的负数了
                return 0;
            }
            result = newResult;
            x /= 10; //相当于每次去掉了最后一位
        }
        return result;
    }
}
