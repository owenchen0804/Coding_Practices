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

        
    }
}
