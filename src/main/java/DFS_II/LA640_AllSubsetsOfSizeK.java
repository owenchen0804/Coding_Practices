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
        //  这里注意，有可能是index已经到最后了，但是一路没怎么append，所以size也不够k，但还是要return
        //  不然得话就死循环出不来了
        //  更好的方法应该是==k的时候直接就early return
//        if (index == array.length) {
//            if (sb.length() == k) {
//                result.add(sb.toString());
//            }
//            return;
//        }
        if (sb.length() == k) {
            result.add(sb.toString());
            return;
        }
        if (index == array.length) {
            return;
        }

        sb.append(array[index]);
        DFS(array, sb, result, index + 1, k);
        sb.deleteCharAt(sb.length() - 1);
        DFS(array, sb, result, index + 1, k);
    }
}
