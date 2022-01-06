package StrongerIII;

import java.util.ArrayList;
import java.util.List;

public class LA171_CommonElementsInThreeSortedArrays {
    public List<Integer> common(int[] a, int[] b, int[] c) {
        List<Integer> result = new ArrayList<>();
        int ai = 0, bi = 0, ci = 0;
        while (ai < a.length && bi < b.length && ci < c.length) {
            if (a[ai] == b[bi] && b[bi] == c[ci]) {
                result.add(a[ai]);
                ai++;
                bi++;
                ci++;
            }
            else if (a[ai] <= b[bi] && a[ai] <= c[ci]) {
                ai++;
            }
            else if (b[bi] <= a[ai] && b[bi] <= c[ci]) {
                bi++;
            }
            else {
                ci++;
            }
        }
        return result;
    }
}
