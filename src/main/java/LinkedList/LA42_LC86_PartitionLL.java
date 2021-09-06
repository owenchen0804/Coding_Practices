package LinkedList;

public class LA42_LC86_PartitionLL {
    public ListNode partitionLL(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode curr1 = small, curr2 = large;
        while (head != null) {
            if (head.value < target) {
                curr1.next = head;
                curr1 = curr1.next;
            }
            else {
                curr2.next = head;
                curr2 = curr2.next;
            }
            head = head.next;
        }
        curr1.next = large.next;    // small LL的尾巴连到large LL的头部
        curr2.next = null;      //  断尾，unlink the last node in large LL
        return small.next;
    }
}