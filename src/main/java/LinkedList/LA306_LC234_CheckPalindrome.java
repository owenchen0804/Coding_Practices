public class LA306_LC234_CheckPalindrome {
    public boolean checkPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null; // 可加可不加 因为即使带着前面middle node也没啥关系
        ListNode two = reverse(middle.next);
        while (two != null) {
            if (head.value != two.value) {
                return false;
            }
            head = head.next;
            two = two.next;
        }
        return true;
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}