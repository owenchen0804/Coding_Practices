package String;

public class LA490_LC159_LongestSubstringWith2DistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map =new int[128];
        int slow = 0, fast = 0;
        int counter = 0;
        int longest = 0;
        while (fast < s.length()) {
            char c1 = s.charAt(fast);
            if (map[c1] == 0) {
                counter++;
            }
            map[c1]++;
            while (counter > 2) {
                char c2 = s.charAt(slow);
                if (map[c2] == 1) {
                    counter--;
                }
                map[c2]--;
                slow++;
            }
            fast++;
            longest = Math.max(longest, fast - slow);
        }
        return longest;
    }
}
