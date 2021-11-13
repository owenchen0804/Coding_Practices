package DFS_II;

import java.util.ArrayList;
import java.util.List;

public class LA643_AllPermutationsOfSubsets {
    public List<String> allPermutations(String input) {
        char[] array = input.toCharArray();
        List<String> result = new ArrayList<>();
        DFS(array, 0, result);
        return result;
    }

    // 每一个解都是从array的开头一直到index，但一开始是0，所以array里面所有的unique char都会被swap到前面变成一个解
    //  之后就是所有的char为2的解，然后是为3的解，以此类推。

    private void DFS(char[] array, int index, List<String> result) {
        // 没有所谓的base case, recursion tree上面的每一个节点都是valid result
        result.add(new String(array, 0, index));
        // all the already chosen positions are (0, index - 1)
        // all the candidates are (index, array.length - 1)
        for (int i = index; i < array.length; i++) {
            swap(array, i, index);
            DFS(array, index + 1, result);
            swap(array, i, index);
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
