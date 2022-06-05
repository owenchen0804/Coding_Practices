package String;

public class LA253_LC3_LongestSubstringWithoutDuplicate {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int slow = 0, fast = 0;
        int result = 0;
        while (fast < s.length()) {
            char c = s.charAt(fast);
            //  只要是fast进来了，那么对应所在的map[c]就需要+1
            map[c]++;
            // fast++;
            while (map[c] > 1) {
                //  == 1的话正好，说明有且只有一个，否则的话就会进到while循环
                //  然后一直移动slow，直到l正好也是c，那么把对应的map[]中的值减到1，才能继续动fast
                char l = s.charAt(slow);
                map[l]--;
                slow++;
            }
            result = Math.max(fast - slow + 1, result);
            fast++;
        }
        return result;
    }

    public static void main(String[] args) {
        LA253_LC3_LongestSubstringWithoutDuplicate test = new LA253_LC3_LongestSubstringWithoutDuplicate();
        String s = "abcbde";
        System.out.println(test.lengthOfLongestSubstring(s));

    }
}
