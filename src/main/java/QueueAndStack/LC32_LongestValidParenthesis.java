package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC32_LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        //  思路是stack里面只存'('所对应的index
        //  left设为-1，表示最后一个不valid的index所在的位置，初始值自然是-1 to cover the edge case
        //  每次看到')'的时候进入清算，如果stack为空的话说明不成对，且产生了新的invalid index，要把left更新
        //  但如果有的话就要先poll出来，成为了一对，然后increasingly update max

        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int left = -1;

        for (int i = 0; i < s.length(); i++) {
            //  如果是(那么就直接放入stack中来等待pairing
            if (s.charAt(i) == '(') {
                stack.offerFirst(i);
            }
            //  否则一定是')'
            //  要看看stack是否为空，如果是空，而现在遇到了')'那么就是invalid的情况，要把left给更新
            else if (stack.isEmpty()) {
                left = i;
            }
            else {
                //  如果是')'且stack有值，那么就poll出来先消掉一对，然后还要考虑stack是不是在poll出一个消掉后是空
                stack.pollFirst();
                if (stack.isEmpty()) {
                    //  如果是空的话说明原来stack就只有一个'('消掉了之后就没了，那么上一个invalid的index = left
                    max = Math.max(max, i - left);
                }
                else {
                    //  否则的话说明里面还有多余的，在等待配对的'('那么要做的是减掉栈顶的那个index
                    max = Math.max(max, i - stack.peekFirst());
                }
            }
        }
        return max;
    }
}
