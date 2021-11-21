package Laicode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LA570_RopeCut {
    public int leastRopeSegments(List<List<Integer>> ropes) {
        // Write your solution here
        // int length = 0;
        // for (int i : ropes.get(0)) {
        //   length += i;
        // }
        int ropeSize = ropes.size();

        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> rope : ropes) {
            int size = rope.size();
            int preSum = 0;
            for (int i = 0; i < size - 1; i++) {
                int curSum = preSum + rope.get(i);
                map.put(curSum, map.getOrDefault(curSum, 0) + 1);
                preSum = curSum;
            }
        }

        int maxLen = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // if (entry.getValue() < minLen) {
            //   minLen = entry.getValue();
            // }
            maxLen = Math.max(maxLen, entry.getValue());
        }
        return ropeSize - maxLen;
    }
}
