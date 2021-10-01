package String;

public class LA253_LC3_LongestSubstringWithoutDuplicate {
    public int lengthOfLongestSubstring(String s) {
        int[] map =new int[128];
        int slow = 0, fast = 0, maxLength = 0;
        int count = 0;
        while (fast < s.length()) {
            char c1 = s.charAt(fast);
            if (map[c1] > 0) {
                count++;
            }
            map[c1]++;
            fast++;
            while (count > 0) {// it means duplicate
                char c2 = s.charAt(slow);
                if (map[c2] > 1) {  // ==1说明正好有一个unique的，>1说明有duplicate了
                    count--;
                }
                map[c2]--;
                slow++;
            }
            maxLength = Math.max(maxLength, fast - slow);
        }
        return maxLength;
    }
}
