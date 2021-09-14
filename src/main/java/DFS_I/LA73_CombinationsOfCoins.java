package DFS_I;

import java.util.ArrayList;
import java.util.List;

public class LA73_CombinationsOfCoins {
    public List<List<Integer>> combinationsOfCoins(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        helper(target, coins, 0, curList, result);
        return result;
    }

    private void helper(int target, int[] coins, int index, List<Integer> curList,
                        List<List<Integer>> result) {
        //  这里index为coins.length - 1就是看最后一个硬币是否能整除，不能整除就直接return了，所以不用再往下分叉
        if (index == coins.length - 1) {

            if (target % coins[index] == 0) {
                curList.add(target / coins[index]);
                result.add(new ArrayList(curList));
                curList.remove(curList.size() - 1);
                // 很重要！这里加了就一定要减掉，否则会带着值返回到上一层！
            }
            return;
        }

        for (int i = 0; i * coins[index] <= target; i++) {
            curList.add(i);
            helper(target - i * coins[index], coins, index + 1, curList, result);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        LA73_CombinationsOfCoins test = new LA73_CombinationsOfCoins();
        int[] coins = {25, 10, 5, 1};
        System.out.println(test.combinationsOfCoins(100, coins));
    }
}
