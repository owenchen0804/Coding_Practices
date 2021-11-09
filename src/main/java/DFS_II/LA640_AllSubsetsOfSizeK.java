package DFS_II;

import java.util.ArrayList;
import java.util.List;

public class LA640_AllSubsetsOfSizeK {
    public List<String> subSetsOfSizeK(String set, int k) {
        // Write your solution here
        if (set == null || set.length() < k) {
            return null;
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] array = set.toCharArray();
        DFS(array, sb, result, 0, k);
        return result;
    }

    private void DFS(char[] array, StringBuilder sb, List<String> result, int index, int k) {
        if (index == array.length) {
            if (sb.length() == k) {
                result.add(sb.toString());
            }
            return;
        }

        sb.append(array[index]);
        DFS(array, sb, result, index + 1, k);
        sb.deleteCharAt(sb.length() - 1);
        DFS(array, sb, result, index + 1, k);
    }
}
