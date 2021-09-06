package LinkedList;

import LinkedList.ListNode;

public class LA39_InsertInSortedLL {
    public ListNode insertLL(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null || head.value >= value) {
            newNode.next = head;
            return newNode;
        }
        ListNode curr = head;
        // 前面cover了head == null的情况，所以这里curr.next一定不会NPE
        while (curr.next != null && curr.next.value <= value) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }
}