package BinarySearch;

public class LC1011_CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        // weights里面单个元素的最大值max是下限，因为根据题意不能用多于1天来搬1堆东西
        // 上限当然是所有的weight加起来，因为有这个capacity的话只要1天就可以了
        int sum = 0, max = 0;
        for (int wei : weights) {
            max = Math.max(max, wei);
            sum += wei;
        }
        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                // 可以完成的话说明还不够低，可以再低点
                mid = right - 1;
            }
            else {
                mid = left + 1;
            }
        }
        return left;
    }

    private boolean canShip(int[] weights, int days, int cap) {
        int day = 1; // 因为是从1开始算日子，不是0-indexed
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            // 一个个wei的试过去
            if (sum + weights[i] > cap) {
                //  如果累加的超过了cap能力，那么今天的货物就是新的sum，可以之后累加，之前的sum就是昨天的
                //  天数还需要++
                sum = weights[i];
                day++;
            }
            sum += weights[i];
        }
        return day <= days;
    }
}
