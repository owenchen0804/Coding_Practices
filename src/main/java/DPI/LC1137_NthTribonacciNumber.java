package DPI;

public class LC1137_NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 0, b = 1, c = 1;
        while (n > 2) {
            int temp = a + b + c;
            a = b;
            b = c;
            c = temp;
            n--;
        }
        return c;
    }
}
