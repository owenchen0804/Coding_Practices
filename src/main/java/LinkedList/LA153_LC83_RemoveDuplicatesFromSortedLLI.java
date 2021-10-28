package LinkedList;

public class LA153_LC83_RemoveDuplicatesFromSortedLLI {
    public ListNode dedup(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.value == curr.next.value) {
                curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }
        }
        return head;
    }
}
