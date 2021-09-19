package String;

import java.util.HashSet;
import java.util.Set;

public class LA395_RemoveCharacters {
    public String removeCharacters(String input, String t) {
        Set<Character> set = new HashSet<>();
        // 注意String没有foreach的办法！
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        char[] array = input.toCharArray();
        // two pointers的情况一般需要把immutable string => char array
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (!set.contains(array[fast])) {
                array[slow++] = array[fast];
            }
        }
        return new String(array, 0 , slow); //  这是[0, slow) 不包括index = slow
    }
}
