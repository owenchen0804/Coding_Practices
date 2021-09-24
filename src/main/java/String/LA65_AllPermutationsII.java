package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LA65_AllPermutationsII {
    public List<String> allPermutationsII(String input) {
        List<String> result = new ArrayList<>();
        if (input == null) {
            return result;
        }
        char[] array = input.toCharArray();
        helper(array, 0, result);
        return result;
    }

    private void helper(char[] array, int index, List<String> result){
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        //  To dedup, each LEVEL should use a HashSet
        //  charSet是每层都有一个，不是像StringBuilder一样在层与层之间跑，所以不需要吃吐！
        Set<Character> charSet = new HashSet<>(array.length);
        //Set<Character> charSet = new HashSet<>();

        for (int i = index; i < array.length; i++) {
            if (!charSet.contains(array[i])) {
                charSet.add(array[i]);
                swap(array, index, i);
                helper(array, index + 1, result);
                swap(array, index, i);
            }
        }
    }

    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }



}
