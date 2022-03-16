package Contest;

public class LC2162_MinimumCostToSetCookingTime {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int maxMins = targetSeconds / 60;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= maxMins; i++) {
            int mins = i;
            int seconds = targetSeconds - mins * 60;
            // 注意这里，targetSeconds可以超过6000，那么maxMins可以到100，但是我们这里不允许，所以也要跳过！
            if (seconds > 99 || mins > 99) {
                continue;
            }
            result = Math.min(result, cost(mins, seconds, startAt, moveCost, pushCost));
        }
        return result;
    }

    private int cost(int mins, int seconds, int startAt, int moveCost, int pushCost) {
        String s = Integer.toString(mins * 100 + seconds);
        char curr = (char) (startAt + '0'); // 强制转换成char，方便一个个数字的计算！
        int cost = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == curr) {
                cost += pushCost;
            }
            else {
                cost += moveCost + pushCost;
                // 注意设定下一个curr，因为还有可能连着的也是相同数字
                curr = s.charAt(i);
            }
        }
        return cost;
    }
}
