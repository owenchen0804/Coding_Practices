package String;

import java.util.ArrayList;
import java.util.List;

public class LA649_StringReplace {
    public String replace(char[] array, String source, String target) {
        if (source.length() >= target.length()) {
            return replaceShorter(array, source, target);
        }
        else {
            return replaceLonger(array, source, target);
        }
    }

    private String replaceShorter(char[] array, String source, String target) {
        int slow = 0, fast = 0;
        // 不能用for循环，因为fast会自己++ !!
        // for (int fast = 0; fast < array.length - source.length(); fast++) {
        while (fast < array.length) {
            if (fast <= array.length - source.length() && equalString(array, fast, source)) {
                copyString(array, slow, target);
                fast += source.length();
                slow += target.length();
            }
            else {
                array[slow++] = array[fast++];
            }
        }
        return new String(array, 0, slow);
    }

    private String replaceLonger(char[] array, String source, String target) {
        List<Integer> matches = getAllMatches(array, source);
        char[] result = new char[array.length + (target.length() - source.length()) * matches.size()];
        int slow = result.length - 1;
        int fast = array.length - 1;
        int lastIndex = matches.size() - 1;
        while (fast >= 0) {
            if (lastIndex >= 0 && fast == matches.get(lastIndex)) {
                copyString(result, slow - target.length() + 1, target);
                slow -= target.length();
                fast -= source.length();
                //  matches.size()--; matches.size()不能自减
                //  matches.remove(matches.size() - 1);
                lastIndex--;

            }
            else {
                result[slow--] = array[fast--];
            }
        }
        return new String(result);
    }

    private boolean equalString(char[] array, int start, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if (array[i + start] != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private void copyString(char[] array, int start, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            array[start + i] = pattern.charAt(i);
        }
    }
    //  拿到所有array[]里面能够match到source string的最后一个字符的index位置, 因为copy是从右到左
    private List<Integer> getAllMatches(char[] array, String source) {
        List<Integer> matchIndexes = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (equalString(array, i, source)) {
                i += source.length() - 1;
                matchIndexes.add(i);
            }
        }
        return matchIndexes;
    }
}
