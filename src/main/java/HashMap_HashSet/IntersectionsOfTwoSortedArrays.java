package HashMap_HashSet;

import java.util.ArrayList;
import java.util.List;

public class IntersectionsOfTwoSortedArrays {
    public List<Integer> intersect(int[] A, int[] B) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                i++;
            } else if (A[i] > B[j]) {
                j++;
            } else {
                ans.add(A[i]);
                i++;
                j++;
            }
        }
        return ans;
    }
}
