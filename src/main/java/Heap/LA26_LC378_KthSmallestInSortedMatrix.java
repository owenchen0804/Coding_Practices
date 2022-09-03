package Heap;

import java.util.*;

public class LA26_LC378_KthSmallestInSortedMatrix {
    private static String[] args;

    //  Assumption: matrix is N * N
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || k <= 0) {
            return -1;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        //  int size = Math.min(k, rows * cols);
        //  不用这么大的size
        int size = Math.min(k, rows);
        boolean[][] visited = new boolean[size][size];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((Cell c1, Cell c2) -> {
            if (c1.val == c2.val) {
                return 0;
            }
            return c1.val < c2.val ? -1 : 1;
        });
        // All the generated cells will be marked true
        // to avoid being generated more than once
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {   // 做k - 1次，第k次直接poll就行了
            // 可以insert back to minHeap的条件:
            //  1. 没有出界matrix
            //  2. 从没有被generated过 - get deduplicated by boolean visited[][]
            Cell curr = minHeap.poll();
            if ((curr.row + 1 < rows) && !visited[curr.row + 1][curr.col]) {
                minHeap.offer(new Cell(curr.row + 1, curr.col, matrix[curr.row + 1][curr.col]));
                visited[curr.row + 1][curr.col] = true;
            }
            if ((curr.col + 1 < cols) && !visited[curr.row][curr.col + 1]) {
                minHeap.offer(new Cell(curr.row, curr.col + 1, matrix[curr.row][curr.col + 1]));
                visited[curr.row][curr.col + 1] = true;
            }
        }
        return minHeap.poll().val;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}

class Cell {
    int row;
    int col;
    int val;
    public Cell(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}