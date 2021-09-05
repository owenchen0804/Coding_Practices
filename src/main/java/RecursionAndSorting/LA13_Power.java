public class LA13Power {
    public long pow(int a, int b) {
        // assume b >= 0
        if (b == 0) {
            return 1;
        }
        // a = 0的情况也要考虑到
        if (a == 0) {
            return 0;
        }
        long half = pow(a, b / 2);
        return b % 2 == 0 ? half * half : half * half * a;
    }
}