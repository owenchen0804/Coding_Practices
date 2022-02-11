package String;

public class LA253_LC3_LongestSubstringWithoutDuplicate {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int slow = 0, fast = 0, maxLength = 0;
        int count = 0;  // count可以针对更多distinct的写法，这里是不许有duplicate，所以不用加count也行，参加👇🏻的solution
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

    public int longest(String input) {
        // Write your solution here
        int[] chars = new int[128];
        int slow = 0, fast = 0, longest = 0;
        while (fast < input.length()) {
            char f = input.charAt(fast);
            chars[f]++;
            while (chars[f] > 1) {  // 如果出现了f character > 1 就一定要把这个character的次数减少到1为止
                // fast才能继续++
                char s = input.charAt(slow);
                chars[s]--;
                slow++;
            }
            fast++;
            longest = Math.max(fast - slow, longest);
        }
        return longest;
    }

    public static void main(String[] args) {
        LA253_LC3_LongestSubstringWithoutDuplicate test = new LA253_LC3_LongestSubstringWithoutDuplicate();
        String s = "abcbde";
        System.out.println(test.lengthOfLongestSubstring(s));

    }
}
