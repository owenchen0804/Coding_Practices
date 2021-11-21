package StrongerI;

import java.util.Arrays;

public class LA117_ArrayDedupIII {
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array.length <= 1) {
            return array;
        }
        int slow = 0;
        boolean flag = false;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] == array[slow]) {
                // 发现重复，要把flag设为true，但是不会对slow所在的index做任何操作，静静等待重复过去
                flag = true;
            }
            else if (flag == true) {
                // 重复的已结束，然后确实有重复，说明slow所在的数字不能要了，并且要把当前的fast对应数据copy到slow上
                array[slow] = array[fast];  // 1-2-2-1 这样2被消掉了，但是1和1还是会保留
                flag = false; // 这里要重新变为false，迎接之后可能有的重复
            }
            else {
                // 既不相等且flag == false表明没有重复，不能overwrite slow
                array[++slow] = array[fast];
            }
        }
        return Arrays.copyOf(array, flag ? slow : slow + 1);
        // 如果最后有重复的比如555, 第1个5会写到slow，但是后面发现重复flag = true了，for循环也结束了，
        //  此时要讨论是否应该保留slow对应的数字

    }
}
