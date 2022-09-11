package Heap;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class LC286_WallsAndGates {
    private static final int EMPTY = Integer.MAX_VALUE;
    //  规定方向的办法，定义一个psf变量的数组
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] {1, 0},
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {0, -1}
    );

    public void wallsAndGates(int[][] rooms) {
        // rooms里面本身就有-1, Integer.MAX_VALUE以及0
        // -1的不用管还是-1，先把GATE也就是值为0的坐标找到放到q里，然后再generate GATE
        //  附近的为INF未知的点
        int m = rooms.length;
        int n = rooms[0].length;
        if (m == 1 && n == 1) {
            return;
        }
        Queue<int[]> q = new ArrayDeque<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == 0) {
                    q.offer(new int[] {row, col});
                }
            }
        }
        while (!q.isEmpty()) {
            //  q是先进先出，所以先会从GATE开始，再放进来所有离GATE距离只有1的点
            //  依此类推再继续扩大各个值为1的点的邻居，标记值为2这样。
            //  墙为-1，逻辑不会涉及到所以会保持不变。
            //  因为从各个GATE开始延伸开的，所以每个INF被改变后也是最小值，不用再担心会被更新
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;   // 以上这些情况不用再visit
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.offer(new int[] {r, c});
            }
        }
    }
}
