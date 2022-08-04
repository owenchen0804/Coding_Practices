package BFS;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LA681_LC773_SevenPuzzle_BFS {
    // Leetcode是2*3的puzzle，所以是1-5，还有一个0，表示是empty的可以swap
    static class Board {
        public final static int R = 2;
        public final static int C = 3;
        private int[][] boards = new int[R][C];
        public Board() {

        }
        public Board(int[][] values) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    boards[i][j] = values[i][j];
                }
            }
        }

        public void swap(int i1, int j1, int i2, int j2) {
            int temp = boards[i1][j1];
            boards[i1][j1] = boards[i2][j2];
            boards[i2][j2] = temp;
        }

        public int[] findZero() {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (boards[i][j] == 0) {
                        // 这里说明一定要有boards[][]这个member field
                        return new int[] {i, j};
                    }
                }
            }
            return null;
        }

        public boolean outOfBound(int i, int j) {
            return i < 0 || i >= R || j < 0 || j >= C;
        }

        @Override
        public int hashCode() {
            int code = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    code = code * 10 + boards[i][j];
                }
            }
            return code;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Board)) {
                return false;
            }
            Board b = (Board) o;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (boards[i][j] != b.boards[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public Board clone() {
            // clone是为了swap过后的存一个hard copy放入queue中继续探索
            // 这里没有用recursion，swap过后clone放入queue后马上就swap回来了
            Board c = new Board();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    c.boards[i][j] = boards[i][j];
                }
            }
            return c;
        }
    }

    final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int slidingPuzzle(int[][] board) {
        Queue<Board> queue = new ArrayDeque<>();
        Map<Board, Integer> map =new HashMap<>();
        Board start = new Board(new int[][] {{1,2,3}, {4,5,0}});
        queue.offer(start);
        map.put(start, 0);
        while (!queue.isEmpty()) {
            Board curBoard = queue.poll();
            int step = map.get(curBoard);
            int[] zeroPos = curBoard.findZero();
            // 找到当前curBoard的那个0，只有0的上下左右可能可以移动
            int zeroI = zeroPos[0];
            int zeroJ = zeroPos[1];
            for (int[] dir : DIRS) {
                int i = zeroI + dir[0];
                int j = zeroJ + dir[1];
                if (!curBoard.outOfBound(i, j)) {
                    curBoard.swap(zeroI, zeroJ, i, j); // 不出界就移动
                    if (!map.containsKey(curBoard)) {
                        Board newBoard = curBoard.clone();
                        // 有新的board出现才clone一下进行下一步，而本身还要swap回来
                        queue.offer(newBoard);
                        map.put(newBoard, step + 1);
                    }
                    curBoard.swap(zeroI, zeroJ, i, j);
                }
            }
        }
        return map.getOrDefault(new Board(board), -1);
    }
}
