package WeeklyContest;

import java.util.Arrays;

public class LC2171_RemovingMinimumNumberOfMagicBeans {
    // nums = a, b, c, d ( a < b < c < d )
    // if make nums [a, a, a, a] remove beans (b - a) + (c - a) + (d - a) == b + c + d - 3a
    // if make nums [0, b, b, b] remove beans a + (c - b) + (d - b) == a + c + d - 2b
    // if make nums [0, 0, c, d] remove beans a + b + (d - c) == a + b + d - c
    // if make nums [0, 0, 0, d] remove beans a + b + c

    // b + c + d - 3a == (a + b + c + d) - 4a
    // a + c + d - 2b == (a + b + c + d) - 3b
    // a + b + d -c == (a + b + c + d) - 2c
    // a + b + c == (a + b + c + d) - d

    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0;
        for (int bean : beans) {
            sum += bean;
        }
        long result = Long.MAX_VALUE;
        long m = beans.length;
        for (int i = 0; i < beans.length; i++, m--) {
            result = Math.min(result, sum - m * beans[i]);
        }
        return result;
    }
}
