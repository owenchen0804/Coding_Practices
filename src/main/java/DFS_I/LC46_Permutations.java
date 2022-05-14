package DFS_I;

import java.util.ArrayList;
import java.util.List;

public class LC46_Permutations {
    public List<List<Integer>> permute(int[] nums) {

//  set注意讨论null和""空串的corner case
//  swap的方法只适用于array，因为需要index和in-place的操作，所以要把input.toCharArray()
//  base case里面，之所以可以在index == array.length - 1，是因为当index到了最后一个position的时候，
//  它的右边没有可以再换的元素了，相当于即使是index == array.length它也只能自己跟自己换，所以从结果上来说和array.length - 1是一样的。
//  swap过去，swap回来都必须要在for循环里面进行，for里面的每一个i相当于对应着每一层index的操作，比如index == 1的时候，i可以取值1和2，所以
//  就是swap(1,1) and swap(1,2)这样。

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        helper(nums, 0, result);
        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length - 1) {
            //  注意这里进行swap-swap操作的input是一个int[] array，
            //  但是output需要arraylist, 所以要先new一个arraylist
            //  然后再依次把swap好的到base case的array的数据放到当前的arrayList里面，再加到result里
            List<Integer> arrayList = new ArrayList<>();
            for (int num : nums) {
                arrayList.add(num);
            }
            result.add(arrayList);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            helper(nums, index + 1, result);
            swap(nums, index, i);
        }
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
