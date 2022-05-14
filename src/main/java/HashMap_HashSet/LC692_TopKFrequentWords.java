package HashMap_HashSet;

import java.util.*;

public class LC692_TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

//  1. 统计String出现的次数，可以就用HashMap<String, Integer>来实现，
//  但是PrioritQueue里面存的类型要搞清楚，是Map.Entry<String, Integer>因为你存的数据
//  是一个个的<Key, Value>值！比较的是value，输出的是key。
//  2. 在override compare的时候因为是比较Integer这个已经定义好的class，所以直接可以用compareTo了，
//  不然的话还需要自己写int compare() method (实际面试的时候就这样写lambda function)
//  3. 本题中minHeap的评判方法是如果value相同的话，按照字母的lexi顺序排，也就是相同value的比如有2个，
//  要都放到minHeap里面，它按照我们规定的顺序，把字母靠后的优先放在了堆顶，然后被poll()出去了，
//  剩下的是那个字母顺序靠前的。
//  4. 这里注意我们维护的是minHeap，但是只有k个，但凡后面有更大的值进来就会把一个最小的推出去。
//  在lambda function里面也已经规定好了；所以相同的value的值得先放到minHeap它会排个序，
//  再把字母靠后的扔掉
//  5. freqArray()纯粹是帮助输出的，把PriorityQueue里面getKey出来的String放到String[] result里面，
//  注意result在new的时候的size应该是minHeap.size()而不是k, 虽然值相同，但是k没有传进这个method读不到。
//  此外，for循环里面倒是可以用result.length-1因为毕竟是个array。

        List<String> result = new ArrayList<>();
        Map<String, Integer> freqMap = getFreqMap(words);
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                (o1, o2) -> o1.getValue() == o2.getValue() ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue());
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            }
            else if (entry.getValue() >= minHeap.peek().getValue()) {
                //  不管大于还是等于都需要放到minHeap里面比较一下，自然会把较小的(相同的话会把lexi更大的)Poll出去
                //  minHeap.poll();
                minHeap.offer(entry);
                minHeap.poll();
            }
        }
        return freqArray(minHeap);
    }

    private Map<String, Integer> getFreqMap(String[] combo) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : combo) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }

    private List<String> freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
        List<String> result = new ArrayList<>();
        int size = minHeap.size();
        for (int i = size; i > 0; i--) {
            result.add(0, (minHeap.poll().getKey()));
        }
        return result;
    }
}
