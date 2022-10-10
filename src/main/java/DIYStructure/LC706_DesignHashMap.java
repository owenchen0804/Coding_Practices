package DIYStructure;

public class LC706_DesignHashMap {
    private final ListNode[] nodes;

    static class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LC706_DesignHashMap() {
        nodes = new ListNode[10000];
    }

    public void put(int key, int value) {
        int i = getIndex(key);
        if (nodes[i] == null) {
            //  说明这个bucket还没有touch到，因此先建一个dummy head
            nodes[i] = new ListNode(-1, -1);
        }

        ListNode prev = find(nodes[i], key);
        //  prev最起码返回prev，后面要么没了说明没有值，要么就下一个就是目标
        if (prev.next == null) {
            //  说明没找到key，那么就append新的ListNode在后面
            prev.next = new ListNode(key, value);
        }
        else {
            prev.next.val = value;
        }

    }

    public int get(int key) {
        int i = getIndex(key);
        if (nodes[i] == null) {
            return -1;
        }
        //  find()返回的是目标node的前面一个
        ListNode prev = find(nodes[i], key);
        // if (node == null) {
        //     return nodes[i].val;
        // }
        return prev.next == null ? -1 : prev.next.val;
    }

    public void remove(int key) {
        int i = getIndex(key);
        //  如果nodes[i] == null 说明直接没有这个bucket，根本不用找
        if (nodes[i] != null) {
            ListNode prev = find(nodes[i], key);
            //  如果prev.next == null 说明bucket存在，但是没有找到对应的key
            //  所以只有一个dummy head在那里
            if (prev.next != null) {
                prev.next = prev.next.next;
            }
        }
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    private ListNode find(ListNode bucket, int key) {
        ListNode curr = bucket, prev = null;
        while (curr != null && curr.key != key) {
            //  如果curr到了null还是要跳出循环的，此时返回的prev指向最后一个ListNode
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
}
