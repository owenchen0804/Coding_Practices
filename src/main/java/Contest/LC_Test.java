package Contest;

import java.util.HashSet;
import java.util.Set;

public class LC_Test {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Set<Point> set = new HashSet<>();
        for (int[] d : dig) {
            Point p = new Point(d[0], d[1]);
            set.add(p);
        }
        int result = 0;
        for (int[] artifact : artifacts) {
            // 对于每一个artifact而言，有4位数字，对应的左上角r1,c1,和右下角r2,c2
            int r1 = artifact[0], c1 = artifact[1], r2 = artifact[2], c2 = artifact[3];
            if (Digged(r1, c1, r2, c2, set)) {
                result++;
            }
        }
        return result;

    }

    private boolean Digged(int r1, int c1, int r2, int c2, Set<Point> set) {
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                Point p = new Point(r, c);
                if (!set.contains(p)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC_Test test = new LC_Test();
        int[][] artifacts = {{0,0,0,0},{0,1,1,1}};
        int[][] dig = {{0,0}, {0,1}};
        System.out.print(test.digArtifacts(2, artifacts, dig));
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
