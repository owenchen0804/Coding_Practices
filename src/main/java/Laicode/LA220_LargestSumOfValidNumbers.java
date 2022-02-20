package Laicode;

import java.util.ArrayList;
import java.util.List;

public class LA220_LargestSumOfValidNumbers {

    public int largestSum(int[][] matrix) {
        int k = 8; // assume matrix is 8 * 8
        List<Integer> configs = validConfigs(k); // 得到所有可能的configs
        //  dp[i][j] =  max possible sum for the submatrix of row 0 - i and row i pick the jth config
        //  注意这里的处理是把matrix平面化成 k rows * 1 col
        //  其中每一行的数据在选择完了之后，就会变成一个固定的config，
        //  然后把它压缩成一个int数字，成为这一行的唯一一个数据，那么这个matrix就只有1个column
        int[][] dp = new int[k][configs.size()]; // 因为虽然想象成只有1列，但是这一列的可能性有config.size()这么多
        for (int i = 0; i < k; i++) {
            // dp[i][j] = max(dp[i - 1][k]) 就是上一行到第0行组成的submatrix里面不和config j冲突的connfig k的最大值
            for (int j = 0; j < configs.size(); j++) {
                dp[i][j] = Integer.MIN_VALUE;
                if (i == 0) {
                    //  如果本身是最上面一行，那么就没有之前的data
                    //  那么直接每个config j都会对应一个dp[][] value出来
                    dp[i][j] = sum(matrix[i], configs.get(j));
                    // dp[][] 本身还是一个二维数组，只是列的每个值都是一行数据经过不同选择后得到的一个个sum
                }
                else {
                    //  有之前的row在的话就变成了一个subMatrix，于是每次衡量标准变成了
                    //  选择前面的rows和一个不和当前config冲突的另一个config
                    for (int l = 0; l < configs.size(); l++) {
                        if (noConflict(configs.get(l), configs.get(j))) {
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][l] + sum(matrix[i], configs.get(j)));
                        }
                    }
                }
            }
        }
        //  the result is max(dp[7][k]) 第七航里面所有dp[][]的值的最大值
        int result = dp[k - 1][0]; //   把第一个值设为result，再逐一比较
        for (int i = 1; i < configs.size(); i++) {
            result = Math.max(result, dp[k - 1][i]);
        }
        return result;
    }

    private List<Integer> validConfigs(int k) {
        //  get ALL Possible configurations, each one is represented as an UNIQUE int value
        //  and we only use lower 8 bits (每个位置的bit如果是1，表示那一个位置的数被选择了)
        //  we guarantee no adjacent bit is chosen for the lowest 8 bits (通过noConflict()来判断)
        List<Integer> configs = new ArrayList<>();
        helper(configs, 0, k, 0);
        return configs;
    }

    private void helper(List<Integer> configs, int index, int k, int cur) {
        //  这里用的recursion，先把0加进去表示整个row都不加的情况，然后每次1 << i位，然后加到cur里面
        //  比如第一位是左移0位得到的1，也就是表示index = 0的地方，依次往右，注意是单行的情况是隔一个index再 |
        //  比如，如果cur = 5, 表示第0位(1)和第2位(4)上面都有数字被选中了，才是1+4=5
        //  注意这里因为往下传递的cur是int primitive type，所以是immutable的，不需要像StringBuilder那样吃和吐
        configs.add(cur);
        for (int i = index; i < k; i++) {
            helper(configs, i + 2, k, cur | (1 << i));
        }
    }

    private boolean noConflict(int c1, int c2) {
        //  conflict means if the ith bit is 1 in c1, then the ith, (i - 1)th, and (i + 1)th bit
        //  cannot be 1 in c2
        return (c1 & c2) == 0 && ((c1 << 1) & c2) == 0 && (c1 & (c2 << 1)) == 0;
    }

    private int sum(int[] array, int config) {
        //  Use the config to calculate the real sum
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (((config >>> i) & 1) != 0) {
                sum += array[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LA220_LargestSumOfValidNumbers test = new LA220_LargestSumOfValidNumbers();
        System.out.println(test.validConfigs(4));
    }
}
