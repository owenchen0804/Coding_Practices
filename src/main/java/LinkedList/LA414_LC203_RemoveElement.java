package LinkedList;

public class LA414_LC203_RemoveElement {
    public ListNode remove(ListNode head, int val) {
        // 1->3->2 val = 1 result => 3->2
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (head != null) {
            if (head.value == val) {
                //  head = head.next;   // 这一步是不管head是不是val都要走的，应该放在if else外面
                curr.next = head.next;  //  跳过了当前的head，但是curr不应该急着移动，在这种情况下要不动，保持在head.next前面一位
            }
            else {
                curr.next = head;   // 要把curr和head搭上
                curr = curr.next;
                // 但是如果一开始用dummy.next = head的话则curr就已经搭上了
                //  之后如果head.value != val的话可以直接curr = head往后走
            }
            head = head.next;
        }
        return dummy.next;
    }
}