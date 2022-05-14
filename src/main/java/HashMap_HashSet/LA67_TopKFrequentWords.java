package HashMap_HashSet;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LA67_TopKFrequentWords {
    public String[] topKFrequent(String[] combo, int k) {
        if (combo.length == 0) {
            return combo;
        }
        Map<String, Integer> freqMap = getFreqMap(combo);
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                (e1, e2) -> {
                    return e1.getValue().compareTo(e2.getValue());
                    // 因为是integer的natural order所以可以直接用compareTo
                });
        PriorityQueue<Map.Entry<String, Integer>> minHeap2 = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue().equals(e2.getValue())) {
                    return 0;
                }
                return e1.getValue() < e2.getValue() ? -1 : 1;
            }
        });

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            // foreach无法识别具体某个hashMap,需要拿到entrySet()!!
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            }
            else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        String[] result = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }

    private Map<String, Integer> getFreqMap(String[] combo) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String s : combo) {
            freqMap.put(s, freqMap.getOrDefault(s, 1) + 1);
        }
        return freqMap;
    }
}
