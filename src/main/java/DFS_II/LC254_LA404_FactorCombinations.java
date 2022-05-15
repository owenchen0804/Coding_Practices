package DFS_II;

import java.util.ArrayList;
import java.util.List;

public class LC254_LA404_FactorCombinations {
    public List<List<Integer>> getFactors(int n) {

//  在helper里面用一个while循环，妙处在于：当factor 是一个legal factor，
//  那么target/factor也是另一个，这俩就可以当做一个solution放在cur里了，所以如果满足条件，
//  先来个快照，把cur里面这两个先照下来。
//  然后要remove掉target/factor，然后继续顺着这条path继续往下递归调用helper。
//  在继续吃完之后是需要接着????的，把之前那个加进去的factor也要吐出来，
//  然后就要factor + 1再进行loop了，最后factor可以取到target的平方根。
//  因为每个condition都考虑到了。在recursion tree上面的每一个valid node也就是
//  成功的method call都会是一个valid solution！



        List<List<Integer>> result = new ArrayList<>();
        if (n <= 1) {
            return result;
        }
        List<Integer> cur = new ArrayList<>();
        helper(2, n, cur, result);
        return result;
    }

    private void helper(int factor, int target, List<Integer> cur, List<List<Integer>> result) {
        while (factor * factor <= target) {
            if (target % factor == 0) {
                cur.add(factor);
                cur.add(target / factor);
                result.add(new ArrayList(cur));
                cur.remove(cur.size() - 1);
                helper(factor, target / factor, cur, result);
                cur.remove(cur.size() - 1);
            }
            factor += 1;
        }
        //factor += 1;
    }
}
