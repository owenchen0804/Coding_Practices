package com.owen.Coding_Practices;

import java.util.Arrays;

public class Test2 {
    int[] start;
    public boolean checkValidGrid(int[][] grid) {
        int length = grid.length;
        int target = length * length - 1;
        start = new int[] {0, 0};
        int[][]DIRS = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        for (int i = 1; i <= target; i++) {

            if (isValid(grid, DIRS, i)) {
                continue;
            }
            else {
                return false;
            }

        }
        return true;
    }

    private boolean isValid(int[][] grid, int[][] DIRS, int target) {
        for (int j = 0; j < 7; j++) {
            start[0] += DIRS[j][0];
            start[1] += DIRS[j][1];
            //  边界情况
            if (start[0] < 0 || start[0] >= grid.length || start[1] < 0 || start[1] >= grid.length) {
                start[0] -= DIRS[j][0];
                start[1] -= DIRS[j][1];
                continue;
            }
            else if (grid[start[0]][start[1]] == target) {
                return true;
            }
            else {
                start[0] -= DIRS[j][0];
                start[1] -= DIRS[j][1];
            }
        }
        return false;
    }

    public static void main(String[] args) {




        int[][] grid = {{0,11,16,5,20}, {17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}};
        //System.out.print(Long.compare(a, 1));
        Test2 test = new Test2();
        test.checkValidGrid(grid);
    }
}
