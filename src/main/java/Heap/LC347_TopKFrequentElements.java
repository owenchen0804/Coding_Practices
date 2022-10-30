package Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        //  bucket sort 适用于这种有限数字的情况，把每个数字出现的freq放到bucket[]里面
        //  且bucket[i]可能对应多个相同freq的情况，因此会用ArrayList存每一个item
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //  统计好freq之后，对于每个freq都开辟arrayList，或者把对应的num加到已开辟的arrayList中
        List<Integer> bucket[] = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        //  freq越大，越会在bucket[]的后面，所以要从后往前数
        int[] result = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                //  bucket[i]可能对应不同的val
                for (int val : bucket[i]) {
                    result[index++] = val;
                    if (index == k) return result;
                }

            }
        }
        return result;
    }
}
