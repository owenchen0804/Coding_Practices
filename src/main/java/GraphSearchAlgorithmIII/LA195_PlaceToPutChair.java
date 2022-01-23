package GraphSearchAlgorithmIII;

import java.util.*;

// 'E' = EQUIP
// 'O' = OB
// 'C' = able to put chair

//  { 'E', 'O', 'C' },
//
//  {  'C', 'E',  'C' },
//
//  {  'C',  'C',  'C' }

public class LA195_PlaceToPutChair {
    private static final char EQUIP = 'E';
    private static final char OB = 'O';
    public List<Integer> putChair(char[][] gym) {
        int M = gym.length;
        int N = gym[0].length;
        int[][] cost = new int[M][N]; // cost表示每个EQUIP到某一个坐标的cost之和！
        // 把所有E到所有点的cost都相加
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (gym[i][j] == EQUIP) {
                    // 每找到一个E，就要把到各个valid point的cost累加起来
                    if (!addCost(cost, gym, i, j)) {
                        return Arrays.asList(-1, -1);
                    }
                }
            }
        }
        // 所有的E对应的cost都找到了，那么现在就是go over所有的valid的点，找cost最小
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (gym[i][j] != EQUIP && gym[i][j] != OB) {
                    if (i == 0 && j == 0) {
                        result = Arrays.asList(i, j);
                    }
                    else if (cost[i][j] < cost[result.get(0)][result.get(1)]) {
                        result.set(0, i);
                        result.set(1, j);
                    }
                }
            }
        }
        return result;
    }

    private boolean addCost(int[][] cost, char[][] gym, int i, int j) {
        // 这里实际上要完成2件事，一件是对应所有的EQUIP，都要把整个gym[][]的可以放chair的点过一遍
        // 算一下cost然后在原来的基础上+=，这样才算得出所有EQUIP到所有点的cost之和
        // 同时，这里要考虑可能某个'E'的周围全是"OB"那么久会拿不到，这样也不行，不符合题意了
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        // 最后返回true/false的依据就是看看每个'E'点是否在visited里，不在的话说明拿不到该椅子，就是false
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(i, j)); // 把当前的坐标i,j先放进去 这是对应的EQUIP
        int pathCost = 1;
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                // 按照level来的，每层都要pathCost++
                Pair curr = queue.poll();
                List<Pair> neis = getNeis(curr, gym); // 这里的neis一定都是valid，不会是OB
                for (Pair nei : neis) {
                    if (!visited[nei.i][nei.j]) {
                        visited[nei.i][nei.j] = true;
                        cost[nei.i][nei.j] += pathCost;
                        queue.offer(nei);
                    }
                }
            }
            pathCost++; // 下一个邻居再出来，它的邻居要再++
        }
        // 这里要根据题意来看，如果真的是有可能EQUIP无法被reach，也就加不到visited里面，所以应该返回false
        // 否则addCost可以不用返回任何值，只是加上cost就可以了
        for (int l = 0; l < gym.length; l++) {
            for (int m = 0; m < gym[0].length; m++) {
                if (gym[l][m] == EQUIP && !visited[l][m]) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<Pair> getNeis(Pair curr, char[][] gym) {
        // Given a Pair location curr, we can find all the valid neighbors and return the neis list
        int x = curr.i;
        int y = curr.j;
        int M = gym.length;
        int N = gym[0].length;
        List<Pair> neis = new ArrayList<>();
        if (x + 1 < M && gym[x + 1][y] != OB) {
            neis.add(new Pair(x + 1, y));
        }
        if (x - 1 >= 0 && gym[x - 1][y] != OB) {
            neis.add(new Pair(x - 1, y));
        }
        if (y + 1 < N && gym[x][y + 1] != OB) {
            neis.add(new Pair(x, y + 1));
        }
        if (y - 1 >= 0 && gym[x][y - 1] != OB) {
            neis.add(new Pair(x, y - 1));
        }
        return neis;
    }

    static class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
