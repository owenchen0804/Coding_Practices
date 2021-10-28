package LinkedList;

public class LC82_RemoveDuplicatesFromSortedLLII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        prev.next = head;
        while (head != null) {
            if (head.next != null && head.value == head.next.value){
                while (head.next != null && head.value == head.next.value) {
                    head = head.next;
                }
                prev.next = head.next;  // 这句是包括了如果LL全是重复的数据！
            }
            else {
                prev.next = head;
                prev = head;
            }
            head = head.next;
        }
        return dummyHead.next;
    }
}
