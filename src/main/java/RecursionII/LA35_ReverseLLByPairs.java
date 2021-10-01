package RecursionII;

import LinkedList.ListNode;

public class LA35_ReverseLLByPairs {
    public ListNode reverseByPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode subHead = reverseByPairs(head.next.next);
        head.next.next = head;
        head.next = subHead;
        return newHead;
    }

    public ListNode reverseInPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        dummy.next = head;
        while (curr.next != null && curr.next.next != null) {// make sure后面至少两个不是null才能
            // 循环继续，否则的话停止
            ListNode next = curr.next.next; //  指向了node2
            curr.next.next = curr.next.next.next;   //  相当于node1.next = node3
            next.next = curr.next;  //  node2.next = node1
            curr.next = next;   // 当前node的下一个指向了node2
            curr = curr.next.next;
        }
        return dummy.next;
    }
}
