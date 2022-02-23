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
        
    }
}
