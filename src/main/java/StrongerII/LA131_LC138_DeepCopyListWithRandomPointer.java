package StrongerII;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    public int value;
    public RandomListNode next;
    public RandomListNode random;

    public RandomListNode(int value) {
        this.value = value;
    }
}

public class LA131_LC138_DeepCopyListWithRandomPointer {
    public RandomListNode copy(RandomListNode head) {
        // Write your solution here.
        if (head == null) {
            return null;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.value));
            }
            cur.next = map.get(head); //不管head在不在map都需要cur连接上
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.value));
                }
                cur.next.random = map.get(head.random);
            }
            cur = cur.next;
            head = head.next;
        }
        return dummy.next;
    }

}
