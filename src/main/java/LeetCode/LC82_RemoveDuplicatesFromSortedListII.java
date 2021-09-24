package LeetCode;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LC82_RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead;
        while (head != null) {  // 其实可以cover both corner cases
            if (head.next != null && head.val == head.next.val){
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;  //  中间重复val的节点都不要
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
