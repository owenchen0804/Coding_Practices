package String;

import java.util.ArrayList;
import java.util.List;

public class LC438_FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] map = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++;
        }

        //  p可能是"aba"这种有重复字母的，所以还是得用count
        //  因为你用match的话，这里没有map，没办法用map.size()
        //  比如凑齐了aab，但是matches只能对应的是2种字母，而不能是p.length() == 3在这里
        int count = p.length();
        int slow = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            char c1 = s.charAt(fast);
            map[c1 - 'a']--;
            if (map[c1 - 'a'] >= 0) {   //  说明这个是在pattern里面的
                count--;
            }

            if (fast >= p.length()) {
                char c2 = s.charAt(slow);
                map[c2 - 'a']++;
                if (map[c2 - 'a'] > 0) {
                    count++;
                }

                slow++;
            }

            if (count == 0) {
                result.add(slow);
            }
        }
        return result;
    }
}
