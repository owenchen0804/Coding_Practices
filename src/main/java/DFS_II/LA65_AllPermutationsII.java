package DFS_II;

import java.util.*;

public class LA65_AllPermutationsII {
    public List<String> allPermutationsII(String input) {
        char[] array = input.toCharArray();
        Arrays.sort(array);
        List<String> result = new ArrayList<>();
        DFS(array, 0, result);
        return result;
    }

    private void DFS(char[] array, int index, List<String> result) {
        if (index == array.length) {
            //  result.add(new String(array, 0, index));
            result.add(new String(array));
            return;
        }
        Set<Character> set = new HashSet<>();
        //  这个hashSet是每层都有一个新的，不是像StringBuilder
        //  跟着index上下跑的，不需要吃吐！
        for (int i = index; i < array.length; i++) {
            if (!set.contains(array[i])) {
                set.add(array[i]);  // 不要忘记加到set中去，做以后的去重dedup
                swap(array, i, index);
                DFS(array, index + 1, result);
                swap(array, i, index);
            }
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
