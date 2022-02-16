package LeetCode;

import java.util.TreeMap;

public class LC1122_LA261_RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 思路是count sort，利用A2现有的顺序，可以用一个comparator，也可以用TreeMap记录A1存进去的自然顺序
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // A1里面是有可能重复的，放到TreeMap里面记录每个数字的次数，并且形成自然有序，符合count sort的思路
        for (int n : arr1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // 根据A2定下来的顺序，利用map里面存好的次数，再在A1里面铺开，利用同一个array就可以，不用开新的空间
        // 先要把A1里面和A2共有的数字放在前面，并且按照A2的顺序来
        int i = 0; // i的左边(exclusive)是A1排好序的，必须在两个for循环之前，先排共有的那部分，再排剩下的
        for (int n : arr2) {
            // n在A1中出现多少次，就要往A1里面重新从index = 0开始排，写多少次
            for (int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
            map.remove(n);  // 这一步很重要！根据n出现次数填写完A1之后
            //  需要去掉这个在A2的n，剩下的是在A1独有的，且保持从小到大的顺序！
        }
        //  当A2的全部排完了之后才轮到A1剩下的，这个要按升序来，所以才需要的TreeMap
        for (int n : map.keySet()) {
            for (int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }
}
