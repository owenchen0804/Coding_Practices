public class LA40_LC21_MergeLL {
    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
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
        //  Link the remaining possible nodes
        if (one == null) {
            curr.next = two;
        }
        else {
            curr.next = one;
        }
        return dummyHead.next;
    }
}