package DIYStructure;

class ListNode {
    int value;
    ListNode next;
    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}

public class LA612_DesignLL {
    //  注意和整个Linked List有关的field只有head，以及eager computation必须要有的length
    public ListNode head;
    public int length;

    public LA612_DesignLL() { //  初始化给LL赋值，遵循0假空原则
        this.head = null;
        this.length = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= length || head == null) {
            return -1;
        }
        ListNode curr = head;
        while (index > 0) {
            curr = curr.next;
            index--;
        }
        return curr.value;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        length++;
        //  return head;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            //  length++;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) {
            return;
        }
        if (index == 0) {
            addAtHead(val); // 这里已经会有length++了
            return;
        } else if (index == length) {
            addAtTail(val); //  这里也有length++
            return;
        } else {
            ListNode newNode = new ListNode(val);
            ListNode curr = head;
            while (index > 1) {    //  比如index == 1就是在第1个（从0开始）index前面插入，所以就是head后面那个，需要循环1次
                curr = curr.next;
                index--;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            length++;
        }
        //  length++:
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length || head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            length--;
        } else {
            ListNode curr = head;
            while (index > 1) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
            length--;
        }
    }
}