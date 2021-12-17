package String;

import java.util.HashSet;
import java.util.Set;

public class LA382_ShortestSubstringWithKTypedCharacters {
    public String shortest(String input, int k) {
        // Write your solution here
        if (input.length() == 0 || k == 0) {
            return new String();
        }
        int len = input.length();
        int slow = 0, fast = 0;
        // [slow, fast) slow: to be kept in result. fast: being processed
        int[] shortest = {0, len};
        while (slow + k <= len) {
            fast = slow;
            Set<Character> set = new HashSet<>();
            // 每次break跳出循环之后fast会从slow再次出发
            while (fast < len) {
                if (set.size() < k) {
                    if (!set.contains(input.charAt(fast))) {
                        set.add(input.charAt(fast));
                    }
                    else if (input.charAt(fast) == input.charAt(slow)) {
                        // 如果slow & fast都指向同一个character那么一定都要右移，这样可以减少fast - slow的长度
                        slow++;
                    }
                    fast++;
                }
                else {
                    break;
                }
            }
            if (set.size() == k) {
                if (fast - slow < shortest[1] - shortest[0]) {
                    shortest[0] = slow;
                    shortest[1] = fast;
                }
            }
            slow++;
        }
        return shortest[0] == 0 && shortest[1] == len ? new String()
                : input.substring(shortest[0], shortest[1]);
    }
}
