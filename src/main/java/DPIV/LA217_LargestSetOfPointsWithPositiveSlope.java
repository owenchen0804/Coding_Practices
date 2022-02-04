package DPIV;

import java.util.Arrays;

class Point{
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class LA217_LargestSetOfPointsWithPositiveSlope {
    public int largest(Point[] points) {
        Arrays.sort(points, (p1, p2) -> {
            if (p1.x == p2.x) {
                return 0;
            }
            return p1.x < p2.x ? -1 : 1;
        });
        int result = 0;
        int[] longest = new int[points.length];
        for (int i = 0; i < longest.length; i++) {

            for (int j = 0; j < i; j++) {
                if (points[j].y < points[i].y) {
                    // 取更大的那个作为新的new longest subsequence
                    longest[i] = Math.max(longest[j], longest[i]);
                }
            }
            longest[i]++;
            //  如果成功找到j，那么再算上i自己那么Points的个数会+1
            //  如果直接就是递减序列的话就单独是自己0+1 = 1
            result = Math.max(result, longest[i]);
        }
        return result == 1 ? 0 : result;
        // result如果还是1，表明最长的subsequence就是自己，说明没有任何两个点能组成正的slope
    }
}
