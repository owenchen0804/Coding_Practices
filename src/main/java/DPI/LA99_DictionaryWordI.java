package DPI;

import java.util.HashSet;
import java.util.Set;

public class LA99_DictionaryWordI {
    public boolean canBreak(String input, String[] dict) {
        Set<String> set = new HashSet<>();
        for (String s : dict) {
            set.add(s);
        }
        //  char[] array = input.toCharArray();
        boolean[] M = new boolean[input.length() + 1];
        M[0] = true;
        //  M[i] represents the substring [0, i)
        //  M[0] represents "", M[1] represents input[0], M[2] => input[0 - 1]
        for (int i = 1; i < M.length; i++) {
            // input got built from i = 1 to input.length()
            for (int j = 0; j < i; j++) {
                // M[j] 表示左大段, 通过查表可以得到结果，右边剩下的小段要通过手动查是否在set里面
                if (M[j] && set.contains(input.substring(j, i))) {  // 必须从j到i，而不是到最后！
                    M[i] = true;
                    break;
                }
                // M[i] = false;
                //  逻辑上没错，但是没必要，因为M[]作为new出来的boolean array本身默认值都是false
            }
        }
        return M[input.length()];
    }
}
