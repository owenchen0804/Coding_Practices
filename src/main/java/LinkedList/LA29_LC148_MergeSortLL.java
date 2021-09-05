public class LA29_LC148_MergeSortLL {

    //  TC:  找中点的时候每层是O(N)的时间，所以到base case的树高是logN, 一共是NlogN
    //       merge的过程和array的情况相同，也是每层每一个Node都要过一遍，一共NlogN
    //  SC:  LL不需要额外空间，所以heap上是O(1)的，然后recursion的树高是O(logN)也就是stack上的space总和
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //  mergeSort(head); mergeSort()不能是void，因为merge LL之后一定要返回ListNode 头结点才行！

        ListNode middle = findMiddle(head);
        ListNode next = middle.next;
        middle.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(next);
        return merge(left, right);
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

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (one != null && two != null) {
            if (one.value <= two.value) {
                curr.next = one;
                one = one.next;
            }
            else {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next;
        }
        if (one != null) {
            curr.next = one;
        }
        else {
            curr.next = two;
        }
        return dummy.next;
    }
}