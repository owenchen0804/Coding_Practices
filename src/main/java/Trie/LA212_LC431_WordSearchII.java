package Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LA212_LC431_WordSearchII {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
    static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        TrieNode root = buildDict(words);   // 用Trie结构来表示所有的words
        StringBuilder sb = new StringBuilder();
        final int rows = board.length;
        final int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        // 对于board里的每一个点都要当成root起点来check
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                helper(board, i, j, root, sb, result, visited);
            }
        }
        return new ArrayList<>(result); // HashSet 变成 arrayList
    }

    private TrieNode buildDict(String[] words) {
        // 所有的word都会放到以root为起点的Trie class里面
        TrieNode root = new TrieNode(); // root一定要先new出来作为Trie结构的起点
        for (String word : words) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode next = curr.children[word.charAt(i) - 'a'];
                if (next == null) {
                    next = new TrieNode();
                    // 如果next没有说明到了实现新单词的地方了，那么当前的TrieNode里的children要放好
                    curr.children[word.charAt(i) - 'a'] = next;
                }
                curr = next;
            }
            // 切记！每放完一个单词要把isWord设为true
            curr.isWord = true;
        }
        return root;
    }

    private void helper(char[][] board, int x, int y, TrieNode root, StringBuilder sb, Set<String> result, boolean[][] visited) {
        // 边界的base case
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
            return;
        }
        char ch = board[x][y];
        if (root.children[ch - 'a'] == null) {
            return; // 不构成任何word退出
        }
        sb.append(ch); // 在当前层先append，然后发现isWord了再加到result
        root = root.children[ch - 'a'];
        if (root.isWord) {
            result.add(sb.toString());
        }
        visited[x][y] = true; // 访问过该点了
        for (int[] dir : DIRS) {
            int neiX = dir[0] + x;
            int neiY = dir[1] + y;
            helper(board, neiX, neiY, root, sb, result, visited);
        }
        // 🤮出来
        visited[x][y] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}
