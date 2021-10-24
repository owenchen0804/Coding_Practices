package DPII;

public class LA97_LC53_MaxSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int globalMax = nums[0];
        int lastMax = nums[0];
        // 因为每次其实都可以东山再起，所以实际上进来一个新的数时要看看前面
        // 如果lastMax是负数就不如东山再起，以免造成了拖累
        // 这个和之前连续ascending还是不同的
        int curLeft = 0;    // 实际上i一直在往前move所以就相当于是curRight
        int globalLeft = 0, globalRight = 0;
        for (int i = 1; i < nums.length; i++) {
            // if (lastMax >= 0) { //  继承遗产
            //     lastMax += nums[i];
            // }
            // else {  //  另起炉灶
            //     lastMax = nums[i];
            // }
            if (lastMax < 0) {  // lastMax会拖累新进来的nums[i]所以要另起炉灶
                curLeft = i;
                lastMax = nums[i];
            }
            else {
                lastMax += nums[i]; // curLeft不变，因为是继承江山
            }
            //  lastMax = Math.max(lastMax + nums[i], nums[i]);
            // 这个就是合并的写法，判断lastMax是否>=0，如果不是那么必然nums[i]更大，就另起炉灶

            //  globalMax = Math.max(lastMax, globalMax);
            //  同样的拆分写法，globalMax真的更新的时候会更新globalLeft & globalRight
            if (globalMax < lastMax) {
                globalLeft = curLeft;
                globalRight = i;
                globalMax = lastMax;
            }
        }
        return globalMax;
    }
}
