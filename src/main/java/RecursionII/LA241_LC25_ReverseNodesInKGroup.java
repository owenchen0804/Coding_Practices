package RecursionII;

import LinkedList.ListNode;

public class LA241_LC25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while (pointer != null) {
            ListNode lastGroupTail = pointer;
            int i = 0;
            for (; i < k; i++) {
                pointer = pointer.next;
                if (pointer == null) {
                    break;
                }
            }
            if (i == k) {
                ListNode nextGroupHead = pointer.next;
                ListNode newHead = reverseK(lastGroupTail.next, nextGroupHead);
                pointer = lastGroupTail.next;   // 找到反转完毕后的尾结点node
                lastGroupTail.next = newHead;
                pointer.next = nextGroupHead;
            }
        }
        return dummy.next;
    }

    private ListNode reverseK(ListNode head, ListNode tail) {
        ListNode prev = null, curr = null;
        while (head != tail) {
            curr = head.next;
            head.next = prev;
            prev = head;
            head = curr;
        }
        return prev;    // 返回的是要反转的最后一个Node
    }
}
