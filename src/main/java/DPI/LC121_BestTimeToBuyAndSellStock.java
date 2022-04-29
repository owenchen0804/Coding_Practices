package DPI;

public class LC121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        //  本身不算是DP，因为每一个price[i]没有取决于前面的i-1,..
        //  但是确实记录了目前遇到的min，并且increasingly update了当前最大的benifit也就是max
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}
