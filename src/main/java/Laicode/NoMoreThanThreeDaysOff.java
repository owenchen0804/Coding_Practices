package Laicode;

import java.util.ArrayList;
import java.util.List;

public class NoMoreThanThreeDaysOff {
    public List<String> BusinessTravelSchedule(int n) {
        // assume n is > 1
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        DFS(n, 1, sb, result);
        return result;
    }

    private void DFS(int n, int index, StringBuilder sb, List<String> result) {
        // base case
        if (index == n) {
            sb.append(n);
            result.add(sb.toString());
            return;
        }
        //  每到一层先append当前的index，然后选择0，1，2，3天放假进入下一层，但是要判断一下能否放假
        //  也就是要回顾下前面6 - i天已经放了多少天假
        //  具体的判断以及append "B"可以各写一个helper function
        sb.append(index);
        for (int i = 0; i <= 3; i++) {
            // i的物理意义是选择放i天假，所以有4个分叉
            if (valid(sb, i)) {
                addBreaks(sb, i);
                // 到下一层
                //  似乎因为要递进到下一层，还要backtrack，所以DFS都要是void的？？？？？
                DFS(n, index + 1, sb, result);
                // 🤮出来
                removeBreaks(sb, i);
            }
        }
    }

    private boolean valid(StringBuilder sb, int i) {
        int start = sb.length() - 1;
        // count how many 'B'
        int count = 0;

        // sb = 1 2 3 4 B 5 B 6 (i)
        int j = start;
        while (j >= start - (6 - i)) {
            if (j < 0) {
                break;
            }
            else if (sb.charAt(j) == 'B') {
                count++;
                j--;
            }
        }
        return count <= 3 - i;
    }

    private void addBreaks(StringBuilder sb, int i) {
        for (int num = 0; num < i; num++) {
            sb.append('B');
        }
    }

    private void removeBreaks(StringBuilder sb, int i) {
        for (int num = 0; num < i; num++) {
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
