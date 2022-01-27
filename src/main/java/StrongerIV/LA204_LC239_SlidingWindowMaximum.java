package StrongerIV;

import java.util.ArrayDeque;
import java.util.Deque;

public class LA204_LC239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        //  deque只需存坐标，而不是对应的某个值
        //  deque的右边是和新进来的array[i]进行比较
        //  deque从左边的first到右边的last存放数据是递减的关系
        //  如果deque的从右边看的比array[i]小的都会扔了，直到还有更大的
        //  左边的first()实际上是存当前window的最大值的index，但是如果index
        //  已经离开window了那就得移出去，然后first()右边的那个就是当前window的最大值
        Deque<Integer> deque = new ArrayDeque<>();
        int start = 0; // the index to write in result array
        for (int i = 0; i < nums.length; i++) { //  i是存的nums[]的坐标 不是值
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                //  我们想要最大值呆的更久一点，所以哪怕相等我们也需要i更大的那个
                //  这样在slide window的时候这个i出去的时间会更晚一些
                deque.pollLast();
            }
            //  能走到这一步，说明要么nums[i]一路横扫了所有deque里面的值，那么deque里只有
            //  nums[i]这一个值了，或者遇到了更大的值在deque的左边部分，那么现在就要
            //  判断peekFirst()这个是否还是在sliding window里面
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();  // 出界了也要扔掉
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                result[start++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
