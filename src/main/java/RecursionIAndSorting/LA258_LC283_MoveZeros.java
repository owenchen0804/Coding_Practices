package RecursionIAndSorting;

public class LA258_LC283_MoveZeros {
    public int[] moveZero(int[] array) {

        // int i = 0, j = array.length - 1;
        int right = array.length - 1;
        for (int i = 0; i < right; i++) {   // i == right的时候实际上执行与否都是和自己交换，没区别
            if (array[i] == 0) {    // 题意是把0都换到右边去
                //  int temp = array[i]; // 反正是换0，不需要用temp存了，直接赋值0
                array[i] = array[right];
                //  array[right] = array[i];
                array[right] = 0;
                right--;
                i--;
            }
            // Otherwise直接i++什么都不做
        }
        return array;
    }
}