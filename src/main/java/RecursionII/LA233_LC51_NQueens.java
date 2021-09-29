package RecursionII;

import java.util.ArrayList;
import java.util.List;

public class LA233_LC51_NQueens {
    public List<List<Integer>> nQueen(int n) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(cur, result, n);
        return result;
    }

    private void helper(List<Integer> cur, List<List<Integer>> result, int n) {
        if (cur.size() == n) {
            //result.add(new ArrayList<>(cur)); 这里尖括号里面要加上type!
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(cur, i)) {
                cur.add(i);
                helper(cur, result, n);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> cur, int column) {
        // 判断放入当前row的Q在第index个位置，是否会与cur List里面所有已加入的Q产生矛盾
        for (int j = 0; j < cur.size(); j++) {
            if (cur.get(j) == column || cur.size() - j == Math.abs(column - cur.get(j))) {
                return false;
            }
        }
        return true;
    }
}
