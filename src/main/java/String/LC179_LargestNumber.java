package String;

import java.util.Arrays;
import java.util.Comparator;

public class LC179_LargestNumber {
    private class LargerComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        //  思路是自定义关于String的comparator，比如3和30怎么排序呢：
        //  本题的意思是比较二者先后相连的大小，也就是330和303哪个大就排前面

        //  要把nums[i]都变成String
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        //  用自定义的Comparator对这个String[]进行排序
        Arrays.sort(strs, new LargerComparator());  //  别忘了这里的Comparator要初始化，加()
        //  如果最前面这个都是0的话，那么整个就是0
        if (strs[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
