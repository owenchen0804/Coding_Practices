package MonoStack;

import java.util.ArrayList;
import java.util.List;

public class LC1762_BuildingsWithOceanView {
    public int[] findBuildings(int[] heights) {
        //  如果是mono stack就正常顺序从左往右看，凡是遇到>= stack.peek()的都要从stack pop出来
        //  只有<的值才能进stack，所以最后的stack一定是一个descending降序排列的。
        //  但是从右往左看不需要任何额外的内存所以space是O(1)的更好
        List<Integer> li = new ArrayList<>();
        int last = Integer.MIN_VALUE;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > last) {
                li.add(i);
                last = heights[i];
            }
        }
        //  Collections.sort(index);
        int index = 0;
        int[] result = new int[li.size()];
        for (int j = li.size() - 1; j >= 0; j--) {
            result[index++] = li.get(j);
        }
        return result;
    }
    
    
}
