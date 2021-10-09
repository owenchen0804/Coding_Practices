package DFS_I;

import java.util.ArrayList;
import java.util.List;

public class LA62_LC78_AllSubsetsI {
    public List<String> subSets(String sets) {
        List<String> result = new ArrayList<>();
        //  注意！这里当sets = ""空的时候，不能直接返回result！
        //  下面的helper() cover了这种情况，把空的sb转成了empty string加到result里面，才是和题目要求的一致！
        if (sets == null) {
            return result;
        }
        char[] arraySet = sets.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(result, arraySet, sb, 0);
        return result;
    }

    private void helper(List<String> result, char[] set, StringBuilder sb, int index) {
        if (index == set.length) {
            result.add(sb.toString());
            return;
        }
        sb.append(set[index]);  //  吃
        helper(result, set, sb, index + 1);
        sb.deleteCharAt(sb.length() - 1);   //  🤮

        helper(result, set, sb, index + 1);
    }
}
