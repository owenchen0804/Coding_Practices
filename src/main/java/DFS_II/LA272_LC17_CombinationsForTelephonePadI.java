package DFS_II;

import java.util.ArrayList;
import java.util.List;

public class LA272_LC17_CombinationsForTelephonePadI {
    public String[] combinations(int number) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        char[] numbers = Integer.toString(number).toCharArray();
        //  int -> String -> char[]
        String[] numToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        helper(result, numbers, numToChar, 0, sb);
        return result.toArray(new String[result.size()]);
        // 把List<String>转成String array,但是在new的时候需要给出result.size()
    }

    private void helper(List<String> result, char[] numbers, String[] numToChar, int level, StringBuilder sb) {
        if (level == numbers.length) {
            result.add(sb.toString());
            return;
        }
        char[] chars = numToChar[numbers[level] - '0'].toCharArray();
        // 比如2对应的是abc，那么在当前level的chars[]表示的就是abc，三种可能都存在
        if (chars.length == 0) { // 如果对应的数字是0或者1会出现这情况
            helper(result, numbers, numToChar, level + 1, sb);
        }
        else {
            for (int i = 0; i < chars.length; i++) {
                helper(result, numbers, numToChar, level + 1, sb.append(chars[i]));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
