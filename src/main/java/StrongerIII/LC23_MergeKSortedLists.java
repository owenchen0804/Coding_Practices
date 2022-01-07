package StrongerIII;

import LinkedList.ListNode;

import java.util.PriorityQueue;

public class LC23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((ListNode l1, ListNode l2) -> {
            if (l1.value == l2.value) {
                return 0;
            }
            return l1.value < l2.value ? -1 : 1;
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            minHeap.offer(lists[i]);
        }
        ListNode curr = dummy;
        while (!minHeap.isEmpty()) {
            curr.next = minHeap.poll(); // poll出来的肯定不是null所以不怕NPE
            if (curr.next.next != null) {
                minHeap.offer(curr.next.next);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
