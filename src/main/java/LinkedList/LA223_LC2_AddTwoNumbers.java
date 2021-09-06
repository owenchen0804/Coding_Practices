package LinkedList;

public class LA223_LC2_AddTwoNumbers {
    // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    //  Output: 7 -> 0 -> 8
    public ListNode addTwoNumber(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        //  int sum = 0;
        ListNode curr = dummy;

        // 以下方法不好，因为当有一个为null另一个不为null还要讨论是否进位，然后还要讨论具体哪一个变null，很复杂
//        while (one != null && two != null) {
//            int sum = (carry + one.value + two.value) % 10;
//            carry = (carry + one.value +two.value)  / 10;
//            curr.next = new ListNode(sum);
//            curr = curr.next;
//        }
        while (one != null || two != null || carry != 0) {
            // 也可以直接把carry当sum来用，这样可以直接+ one/two的值
            int sum = 0;    // 每次对于某一位是单独计算one.value + two.value + carry的，所以每次循环进来carry清零
            if (one != null) {
                sum += one.value;
                one = one.next;
            }
            if (two != null) {
                sum += two.value;
                two = two.next;
            }
            if (carry != 0) {
                sum += carry;
            }
            carry = sum / 10;
            sum = sum % 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
        }
        return dummy.next;
    }
}