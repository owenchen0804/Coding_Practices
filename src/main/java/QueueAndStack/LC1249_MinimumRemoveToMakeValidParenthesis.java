package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class LC1249_MinimumRemoveToMakeValidParenthesis {
    public String minRemoveToMakeValid(String s) {
        //  思路是用stack来存左括号的index，然后遇到右括号进行清算
        //  清算的时候看看stack里面如果有值说明是valid，可以进行消消乐了
        //  否则，如果stack为空，那么当前的右括号就属于invalid，要把index放到set里
        //  还有情况是stack不为空，但是右括号没了，这就是剩下的左括号都invalid，也要加index到set里

        //  set用来存Invalid index
        Set<Integer> set = new HashSet<>();
        //  stack存的是左括号的index
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            //  遇到左括号就只用加到stack中
            if (s.charAt(i) == '(') {
                stack.offerFirst(i);
            }
            else if (s.charAt(i) == ')') {
                //  如果遇到的是右括号，那么要判断一下stack是否为空
                //  不为空的话直接可以消消乐，如果为空那么说明有Invalid右括号，放入set中
                if (!stack.isEmpty()) {
                    stack.pollFirst();
                }
                else {
                    set.add(i);
                }
            }
        }
        //  stack里面可能还有没有配对的左括号，也要加到set里面
        while (!stack.isEmpty()) {
            set.add(stack.pollFirst());
        }
        //  Output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
