package Trie;

class TrieNode {
    private TrieNode[] links;
    private final int R = 26; // only 26 lower case letters
    private boolean isWord;
    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node; // 把某一个character放到links[]里面
    }
    public void setWord() {
        isWord = true;
    }
    public boolean isWord() {
        return isWord;
    }
}

public class LC208_ImplementTrie {
    private TrieNode root;

    public LC208_ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (search(word)) {
            return;
        }
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            TrieNode next = curr.get(curLetter);
            if (next == null) {
                // 当出现和所有的prefix都不同的时候，或者Trie上有leet，但我要Insert leetcode的时候
                next = new TrieNode();
                curr.put(curLetter, next);
            }
            curr = next;
        }
        curr.setWord();
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            TrieNode next = curr.get(curLetter);
            if (next == null) {
                return false;
            }
            curr = next;
        }
        return curr.isWord();
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char curLetter = prefix.charAt(i);
            TrieNode next = curr.get(curLetter);
            if (next == null) {
                return false;
            }
            curr = next;
        }
        return true;
    }
}
