package HashMap_HashSet;

import java.util.HashMap;
import java.util.Map;

public class LC2374_NodeWithHighestEdgeScore {
    public int edgeScore(int[] edges) {
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i], map.getOrDefault(edges[i], (long) 0) + i);
        }
        int result = 0;
        long max = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
