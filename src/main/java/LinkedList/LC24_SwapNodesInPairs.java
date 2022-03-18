package LinkedList;

public class LC24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;    // base case，只有一个或者自己就是null的时候返回
        }

        ListNode next = head.next;
        ListNode subHead = swapPairs(next.next);
        next.next = head;
        head.next = subHead;
        return next;
    }
}
