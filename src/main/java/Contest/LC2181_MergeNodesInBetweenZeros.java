package Contest;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LC2181_MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = slow;
        while (fast != null) {
            while (fast.val != 0) {
                fast = fast.next;
            }
            //  此时fast指向下一个0
            int num = calculate(slow, fast);
            ListNode cur = new ListNode(num);
            // 这里还需要一个prev来跟着cur走,slow的话要跟着fast走
            prev.next = cur;
            slow = fast;
            fast = fast.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }

    private int calculate(ListNode slow, ListNode fast) {
        int count = 0;
        while (slow != fast) {
            slow = slow.next;
            count += slow.val;

        }
        return count;
    }

    public static void main(String[] args) {
        LC2181_MergeNodesInBetweenZeros test = new LC2181_MergeNodesInBetweenZeros();
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(0);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(0);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        test.mergeNodes(n1);
    }
}
