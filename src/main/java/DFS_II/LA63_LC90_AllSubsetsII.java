package DFS_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LA63_LC90_AllSubsetsII {
    public List<String> subSetsII(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        //  很重要的一步！！算法和I的不同就在于：比如abbbbb，如果第一个b不要的话，那么后面的b也都不能要!所以要先sort好
        Arrays.sort(arraySet);
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);
        return result;
    }

    private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        if (index == set.length) {
            result.add(sb.toString());
            return;
        }
        sb.append(set[index]);
        helper(set, sb, index + 1, result);
        sb.deleteCharAt(sb.length() - 1);

        // 如果选择不append当前的index，那么后面如果有重复的也不能要
        while (index + 1 < set.length && set[index] == set[index + 1]) {
         index++;   // 当set[index] 不等于set[index + 1]的时候跳出，比如abbc，当index = 2跳出
        }
        helper(set, sb, index + 1, result);
        // index跳到了3的位置，也就是完成了不+b的过程，进入到讨论+还是不+c
    }
}
