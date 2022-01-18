package GraphSearchAlgorithmIII;

import java.util.*;

public class LA662_LC126_WordLadderII {
    /**
     * High level design: BFS + DFS
     *
     * Step 1: use BFS to build graph 从end做BFS到start，hashMap记录到各单词的distance
     *
     * Step 2: use DFS to traverse and record path from beginWord to endWord with shortest path. 取
     * distance依次减少1的路径
     * */

    public List<List<String>> findLadders(String start, String end, List<String> dict) {
        List<List<String>> ans = new ArrayList<>();
        if(dict == null || dict.size() == 0){
            return ans;
        }
        List<String> wordlist = new ArrayList<String>();
        wordlist.add(start);

        if(start.equals(end)){
            ans.add(wordlist);
            return ans;
        }
        Set<String> dicts = new HashSet<>();
        for (String word : dict) {
            dicts.add(word);
        }
        if (!dicts.contains(end)) {
            return ans;
        }
        //记得加start，这里是
        dicts.add(start);
        Map<String, Integer> hashmap = new HashMap<String, Integer>();
        bfs(end, start, dicts, hashmap);
        dfs(start, end, dicts, ans, wordlist, hashmap);
        return ans;
    }
    private void bfs(String end, String start, Set<String> dict, Map<String, Integer> hashmap){
        Queue<String> queue = new LinkedList<String>();
        int length = 0;
        queue.add(end);
        hashmap.put(end, length);

        while(!queue.isEmpty()){

            int size = queue.size();
            length++;

            for(int i = 0; i < size; i++){
                String word = queue.poll();

                for(String nextword : nextWord(word, dict)){
                    if(hashmap.containsKey(nextword)){
                        continue;
                    }
                    queue.add(nextword);
                    hashmap.put(nextword, length);
                }
            }
        }
    }
    private void dfs(String start, String end, Set<String> dict, List<List<String>> result, List<String> path, Map<String, Integer> hashmap){
        if(start.equals(end)){
            result.add(new ArrayList<String>(path));
            return;
        }
        for(String nextword : nextWord(start, dict)){
            if(hashmap.get(nextword) + 1 == hashmap.get(start)){
                path.add(nextword);
                dfs(nextword, end, dict, result, path, hashmap);
                path.remove(path.size() - 1);
            }
        }
    }
    private ArrayList<String> nextWord(String word, Set<String> dict){
        ArrayList<String> nextWord = new ArrayList<String>();
        for(int i = 0; i < word.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(c == word.charAt(i)){
                    continue;
                }
                String newWord = replace(word, i, c);
                if(dict.contains(newWord)){
                    nextWord.add(newWord);
                }
            }
        }
        return nextWord;
    }

    private String replace(String word, int i, char c){
        StringBuilder sb = new StringBuilder(word);
        sb.setCharAt(i, c);
        return sb.toString();
    }
}
