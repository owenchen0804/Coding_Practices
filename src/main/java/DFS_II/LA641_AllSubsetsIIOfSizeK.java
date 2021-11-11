package DFS_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LA641_AllSubsetsIIOfSizeK {
    public List<String> subSetsIIOfSizeK(String set, int k) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        helper(array, sb, 0, k, result);
        return result;
    }
    private void helper(char[] array, StringBuilder sb, int index, int k, List<String> result) {
        if (sb.length() == k) {
            result.add(sb.toString());
            return;
        }
        if (index == array.length) {
            return;
        }
        sb.append(array[index]);
        helper(array, sb, index + 1, k, result);
        sb.deleteCharAt(sb.length() - 1);
        while (index + 1 < array.length && array[index] == array[index + 1]) {
            index++;
        }
        helper(array, sb, index + 1, k, result);
    }
}
