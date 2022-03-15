package DIYStructure;



public class LC707_DesignLL {

    class ListNode {
        ListNode next;
        int val;
        public ListNode(int val) {
            this.val = val;
        }
    }


    private ListNode head;  //  包含一个虚拟的头结点，不存实际的数
    int size;

    public LC707_DesignLL() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        //  不算head的话，要往后走index + 1次
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = head;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val); // index = 0 才是真正的起点，head上本身不存数据
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0; // 说明直接插在head的后面变成新的有实际意义的第一个Node
        }
        size++;
        ListNode prev = head;
        for (int i = 0; i < index; i++) {
            // 走index-1次，到达index前面那个node
            prev = prev.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = prev.next;
        prev.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode prev = head;
        for (int i = 0; i < index; i++) {
            // 走index-1次，到达index前面那个node
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }
}
