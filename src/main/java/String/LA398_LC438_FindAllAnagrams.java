package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LA398_LC438_FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        Map<Character, Integer> map = getMap(p);
        //  int slow = 0, fast = 0,
        int matches = 0;
        int slow = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            char c1 = s.charAt(fast);
            Integer count = map.get(c1);
            if (count != null) {
                map.put(c1, count - 1);
                if (count == 1) {
                    matches++;
                }
            }
            if (fast >= p.length()) {
                char c2 = s.charAt(slow);
                count = map.get(c2);
                if (count != null) {
                    map.put(c2, count + 1);
                    if (count == 0) {
                        matches--;
                    }
                }
                slow++;
            }
            if (matches == map.size()) {
                result.add(slow);
            }
        }
        return result;
    }

    private Map<Character, Integer> getMap(String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
