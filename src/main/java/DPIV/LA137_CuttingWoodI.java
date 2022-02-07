package DPIV;

public class LA137_CuttingWoodI {
    public int minCost(int[] cuts, int length) {
        // cuts里面的每一个表示能下刀的地方，length表示木头的总长度
        int[] helper = new int[cuts.length + 1];
        // 算cost的时候需要算某一段需要起点终点，所以要给helper[0]和helper[length]各一个值
        helper[0] = 0;
        helper[helper.length - 1] = length;
        for (int i = 0; i < cuts.length; i++) {
            helper[i + 1] = cuts[i];
        }

        //  minCost[i][j]物理意义: the minimum cost of cutting the wood partition(i, j)
        //  整体对于matrix填数字的趋势是以i = j的对角线上半区(row < col)然后从对角线一列列(col i固定)往上填写
        int[][] minCost = new int[helper.length][helper.length];
        for (int i = 1; i < helper.length; i++) {
            // i 也是从第一个刀口，慢慢build, up to 整个wood的长度length
            for (int j = i - 1; j >= 0; j--) {
                // j是更小的刀口，当i和j相邻时根据题意类似minCost[1][2], minCost[3][4]等都是0
                if (i == j + 1) {
                    //  相邻的情况没法下刀切，所以为0
                    minCost[j][i] = 0;
                }
                else {
                    minCost[j][i] = Integer.MAX_VALUE; //   这个要decreasingly update
                    for (int k = j + 1; k <= i - 1; k++) {
                        minCost[j][i] = Math.min(minCost[j][i], minCost[j][k] + minCost[k][i]);
                    }
                    //  不要忘了如果不是0的话需要算上(i, j)这段的长度作为cost
                    minCost[j][i] += helper[i] - helper[j];
                }
            }
        }
        return minCost[0][helper.length - 1]; // 最终我们想要的结果是从0到总的length之间长度wood的cost
    }
}
