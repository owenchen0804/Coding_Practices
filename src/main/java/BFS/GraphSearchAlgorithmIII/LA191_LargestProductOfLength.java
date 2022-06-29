package BFS.GraphSearchAlgorithmIII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LA191_LargestProductOfLength {
    public int largestProduct(String[] dict) {
        // sort the input dict 降序排列 优先选出最长的两个相乘
        Arrays.sort(dict, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                return 0;
            }
            return s1.length() < s2.length() ? 1 : -1;
        });
        Map<String, Integer> bitMask = getBitMask(dict);

        int largest = 0;

        for (int i = 1; i < dict.length; i++) {
            for (int j = 0; j < i; j++) {
                int prod = dict[i].length() * dict[j].length();
                if (prod <= largest) {
                    break; // 如果还没判断是否unique连长度都比当前的largest小的话直接跳出当前的循环
                }
                // 能走到这里，说明prod.length一定比largest要大
                int iMask = bitMask.get(dict[i]);
                int jMask = bitMask.get(dict[j]);
                if ((iMask & jMask) == 0) {
                    largest = prod;
                }
            }
        }
        return largest;
    }

    private Map<String, Integer> getBitMask(String[] dict) {
        Map<String, Integer> bitMask = new HashMap<>();
        for (String s : dict) {
            int bitRep = 0;
            for (int i = 0; i < s.length(); i++) {
                // 'a' - 'z' 可以都map到一个int中还有富余
                // 对于当前s的每一位都可以这样map到bitRep中
                bitRep |= 1 << (s.charAt(i) - 'a');
            }
            bitMask.put(s, bitRep);
        }
        return bitMask;
    }
}
