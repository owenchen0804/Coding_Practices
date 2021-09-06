package LinkedList;

public class LA41_LC143_ReorderLL {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode next = middle.next;
        middle.next = null;
        ListNode two = reverse(next);
        return merge(head, two);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null || fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (one != null && two != null) {
            curr.next = one;
            one = one.next;
            curr = curr.next;
            curr.next = two;
            two = two.next;
            curr = curr.next;
        }
        if (one != null) {
            curr.next = one;
        }
        return dummy.next;
    }
}