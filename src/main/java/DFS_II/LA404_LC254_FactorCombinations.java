package DFS_II;

import java.util.ArrayList;
import java.util.List;

public class LA404_LC254_FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 1) {
            return result;
        }
        List<Integer> cur = new ArrayList<>();
        List<Integer> factors = getFactorList(n);
        DFS(n, factors, 0, cur, result);
        return result;
    }

    private void DFS(int n, List<Integer> factors, int index, List<Integer> cur,
                     List<List<Integer>> result) {
        if (index == factors.size()) {
            if (n == 1) {   // 如果已经n变成1了，说明已经分解完成了
                result.add(new ArrayList<>(cur));
            }
            return;
        }
        // 这一层的factor不加进去直接到下一层
        DFS(n, factors, index + 1, cur, result);
        int factor = factors.get(index);
        int size = cur.size();
        while (n % factor == 0) {
            cur.add(factor);
            n /= factor;
            DFS(n, factors, index + 1, cur, result);
        }
        cur.subList(size, cur.size()).clear();  // [size, cur.size())要清除，就是🤮
    }

    private List<Integer> getFactorList(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = n / 2; i > 1; i--) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        LA404_LC254_FactorCombinations test = new LA404_LC254_FactorCombinations();
        // List<List<Integer>> result = test.getFactors(16);

        System.out.println(test.getFactors(16));
    }


    public List<List<Integer>> getFactors2(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 1) {
            return result;
        }
        List<Integer> cur = new ArrayList<>();
        //  List<Integer> factors = getFactorList(n);
        DFS2(n, 2, cur, result);
        return result;
    }

    private void DFS2(int n, int factor, List<Integer> cur,
                     List<List<Integer>> result) {
        while (factor * factor <= n) {
            if (n % factor == 0) {
                cur.add(factor);
                cur.add(n / factor);
                result.add(new ArrayList<Integer>(cur));
                cur.remove(cur.size() - 1);
                DFS2(n / factor, factor, cur, result);
                cur.remove(cur.size() - 1);
            }
            factor += 1;
        }

    }
}
