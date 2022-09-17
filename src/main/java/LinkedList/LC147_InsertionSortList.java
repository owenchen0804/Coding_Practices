package LinkedList;

public class LC147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);

        //  这里随时head都有可能发生变化，只要发现了更小的值，都会变成新的头结点，所以要注意！

        while (head != null) {
            //  每次都要存下来输入链表的下一个node
            ListNode next = head.next;
            //  每次循环都得从dummyHead和curr，也就是当前的头结点出发，寻找
            ListNode prev = dummyHead;
            ListNode curr = prev.next;
            while (curr != null && head.value > curr.value) {
                //  一定要严格大于才移动，不然只是等于的话也不用再移动，因为是extra work
                prev = curr;
                curr = curr.next;
            }
            //  走到这里，要么是只有一个节点，curr直接就是null进不了上面的循环
            //  要么就是走到了head.val <= curr.val的地方，该insert了
            prev.next = head;
            head.next = curr;
            head = next;
        }
        return dummyHead.next;
    }
}
