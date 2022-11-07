package DFS_I;

import java.util.ArrayList;
import java.util.List;

public class LA155_LC77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        DFS(result, cur, 1, n, k);
        return result;
    }

    private void DFS(List<List<Integer>> result, List<Integer> cur, int index, int n, int k) {
        if (cur.size() == k) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        if (index > n) {
            //  注意，当index == n的时候正好是是否选择最后一个数（可选范围是从1到n的闭区间），所以还不能退出！要>n才可以
            return;
        }
        cur.add(index);
        DFS(result, cur, index + 1, n, k);
        cur.remove(cur.size() - 1);
        DFS(result, cur, index + 1, n, k);
    }
}

