package StrongerIII;

import java.util.ArrayList;
import java.util.List;

public class LA644_CommonElementsInKSortedLists {
    public List<Integer> common(List<List<Integer>> input) {
        // assume input不为空，采用的方法是一个个list进行比较
        List<Integer> result = input.get(0);

        for (int i = 0; i < input.size(); i++) {
            result = helper(result, input.get(i));
        }
        return result;
    }

    private List<Integer> helper(List<Integer> a, List<Integer> b) {
        List<Integer> common = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            
        }
    }
}
