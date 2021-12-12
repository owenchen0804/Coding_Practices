package StrongerII;

import java.util.HashMap;
import java.util.Map;

// 只能用作不要求返回具体index而是只判断true or false的情况
// 搞一个pair class，这样相当于是把4个数降低变成了2个pair，算法的本质其实和2Sum的办法很接近
// map的key是得到的数字，而具体的value则是对应的pair的左右index

class Pair{
    int left;
    int right;
    //  int sum;
    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
        //  sum = nums[left]
    }
}

public class LA188_4Sum {
    public boolean fourSum(int[] nums, int target) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int sum = nums[i] + nums[j];
                if (map.containsKey(target - sum) && map.get(target - sum).right < j) {
                    // 需要对应的Pair的右边更大的坐标小于当前更小的j坐标，才能凑成4个从小到大的不重复indexes
                    return true;
                }
                // 如果有target - sum但是坐标对不上也不行
                // 如果没有，那么相当于有新的key出现，要存到map里面
                map.put(sum, new Pair(j, i));
            }
        }
        return false;
    }
}
