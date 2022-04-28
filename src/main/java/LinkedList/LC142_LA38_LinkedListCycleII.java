package LinkedList;

public class LC142_LA38_LinkedListCycleII {
 public ListNode detectCycle(ListNode head) {
  if (head == null || head.next == null) {
   return null;
  }
  if (head.next == head) {
   return head;
  }
  ListNode slow = head, fast = head;
  ListNode start = null;
  //  先看看是否有环
  while (fast != null && fast.next != null) {
   slow = slow.next;
   fast = fast.next.next;

   if (slow == fast) {
    //  如果出现了fast追上了slow，那么从当前位置和从head起点位置，走到二者
    //  相遇的地方，就是环开始的地方
    start = slow;
    while (start != head) {
     start = start.next;
     head = head.next;
    }
    return start;
   }
  }
  //  走到这里说明没有环
  return start;
 }
}

