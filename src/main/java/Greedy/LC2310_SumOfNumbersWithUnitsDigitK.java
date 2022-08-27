package Greedy;

public class LC2310_SumOfNumbersWithUnitsDigitK {
    public int minimumNumbers(int num, int k) {
        //  A1 + A2 + ... + An = n*k + 10*(a1 + a2 + .. + an) = num
        //  所以如果左边 % 10 和右边 % 10能相等，那么n越少越好
        //  比如k = 9，假设n = 1，那么左边 = 9， 右边 = 58，显然%10后左右不等
        //  比如n = 2，那么左边9 * 2 + 10 * any, 这个值%10得8，和58%10一样，满足条件
        if (num == 0) {
            return 0;
        }
        for (int i = 1; i <= 10; i++) {  // 每隔10是一样的，所以只用看前10
            if ((i * k) % 10 == num % 10 && i * k <= num) {
                return i;
            }
        }
        return -1;
    }
}
