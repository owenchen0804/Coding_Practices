package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LC76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int slow = 0;
        int count = t.length(); // need to match all the characters, including possible duplicates
        int minLeft = 0;
        int minLength = s.length(); //  最多就s的长度
        boolean flag = false;   // 如果一直没有匹配上就要返回""，否则的话flag设为true
        //  有可能的2种情况是一直没有匹配上，那么minLength没变；还有一种是用了整个s.length()才匹配上，
        //  两种情况只能用flag的T/F情况来区分
        for (int fast = 0; fast < s.length(); fast++) {
            // fast指针一直保持右移，当出现map里面包含的字符时，count--
            char c1 = s.charAt(fast);
            if (map.containsKey(c1)) {
                // if (map.get(c1) > 0) {
                //     // == 0的话说明虽然有这个character但是已经前面meet过了
                //     count--;
                //     map.put(c1, map.get(c1) - 1);
                // }
                //  只要是有的key都要改变值，因为sliding window可能包含2个B，移走1个，另一个B还是在其中的，必须要统计
                map.put(c1, map.get(c1) - 1);   //  map这里关于c1的value可以是负数！表示over needed
                if (map.get(c1) >= 0) {
                    count--;    // 只有c1还没有找完，或者这一次刚好找完，才会动count
                    //  否则count可以是负数的
                }
            }

            while (count == 0) {    // 能进来说明match上了，那么要先比较拿到minLength，再move slow向右
                flag = true;
                if (fast - slow + 1 < minLength) {
                    minLeft = slow;
                    minLength = fast - slow + 1;
                }
                char c2 = s.charAt(slow);
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if (map.get(c2) >= 1) {
                        //  只有之前是>=0，也就是刚好找完或者还没找好的
                        //  这里slow发现了才会让count++
                        //  否则如果是负数的话相当于这个character多找到了这么多次
                        //  比如B对应的只有1个，我这一个window里面有3个B，那么相当于map.get(B) = -2
                        //  移走一个B，map.get(B) = -1，还有富余，不会让count变化
                        //  哪怕再移走一个B，map.get(B) = 0，也是正好，不影响count
                        //  只有B都没了，那么map.get(B) = 1，这个时候缺B了，count++
                        count++;
                    }
                }
                slow++;
            }
        }
        return flag == true ? s.substring(minLeft, minLeft + minLength) : "";
    }

    public static void main(String[] args) {
        LC76_MinimumWindowSubstring test = new LC76_MinimumWindowSubstring();
        test.minWindow("ADDBECODEBANC", "ABC");
    }
}
