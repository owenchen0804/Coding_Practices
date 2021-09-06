package LinkedList;

public class LA34_LC206_Reverse_LL {
    public ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

