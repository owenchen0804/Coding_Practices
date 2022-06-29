package BFS.GraphSearchAlgorithmIII;

import java.util.*;

public class LA661_LC127_WordLadderI {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>(wordList);
        queue.offer(beginWord);
        int count = 1; // 根据题意，从beginWord开始算1，且beginWord不在set中不用去掉
        while (!queue.isEmpty()) {
            int size = queue.size(); // 外层循环一层层展开，每层距离上一层都是1
            for (int i = 0; i < size; i++) {
                char[] curr = queue.poll().toCharArray();
                for (int j = 0; j < curr.length; j++) {
                    // 改变curr的每一个letter看看是否能在wordList里面
                    char temp = curr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        curr[j] = c;
                        String next = new String(curr);
                        if (set.contains(next)) {
                            if (endWord.equals(next)) {
                                return count + 1;
                            }
                            queue.offer(next);
                            set.remove(next);
                        }
                    }
                    curr[j] = temp;
                }
            }
            count++;
        }
        return 0;
    }
}
