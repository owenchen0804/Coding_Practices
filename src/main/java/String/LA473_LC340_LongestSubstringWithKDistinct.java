package String;

public class LA473_LC340_LongestSubstringWithKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[128];
        int slow = 0, fast = 0;
        int longest = 0, counter = 0;
        while (fast < s.length()) {
            char c1 = s.charAt(fast);
            if (map[c1] == 0) {
                counter++;
            }
            map[c1]++;
            fast++;
            while (counter > k) {
                char c2 = s.charAt(slow);
                if (map[c2] == 1) {
                    counter--;
                }
                map[c2]--;
                slow++;
            }
            longest = Math.max(longest, fast - slow);
        }
        return longest;
    }
}
