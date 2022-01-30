package StrongerIV;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LA208_FirstNonRepeatingCharacterInStream {
    static class Node {
        Node prev;
        Node next;
        Character ch;
        Node(Character ch) {
            this.ch = ch;
        }
    }
    //  record the head and tail of the Double LinkedList all the time
    //  only the characters appearing just once will be in the list
    private Node head;
    private Node tail;
    //  任何character只可能3种状态:
    //  1. 还没出现过，所以map, set里都没有
    //  2. 只出现一次，会在map里面，且node还会在list里面
    //  3. 出现多次，会从list和map里被删掉，并放到set中
    private Map<Character, Node> singled;
    private Set<Character> repeated;

    // constructor需要给head/tail赋初值并且变成circular DLL
    public LA208_FirstNonRepeatingCharacterInStream() {
        tail = new Node(null);
        tail.prev = tail;
        tail.next = tail;
        head = tail;
        singled = new HashMap<Character, Node>();
        repeated = new HashSet<Character>();
    }

    public void read(char ch) {
        if (repeated.contains(ch)) {
            return;
        }
        // 有可能是第二次出现，之前的ch作为首次出现会在map中但不在set中
        Node node = singled.get(ch);
        if (node == null) {
            // map里面没有，说明是首次出现
            node = new Node(ch); // 新建一个Node
            append(node);
        }
        else {  // node已经在map里了，现在需要把它移出map和从list删除
            remove(node);
        }
    }

    private void append(Node node) {
        singled.put(node.ch, node); //  这个正式进入单独出现的HashMap中
        tail.next = node;   //  每次在tail的后面append
        node.prev = tail;
        tail = tail.next;   //  然后tail还要指向最后一个node
        node.next = head;   //  circularLL所以要走回去
    }

    private void remove(Node node) {
        //  这个node一定之前在DLL里面和Map里面，否则不会到remove()这里
        //  由于是DLL，所以我们不需要从head/tail也能O(1)时间找到
        node.prev.next = node.next;
        node.next.prev = node.prev;
        repeated.add(node.ch);
        singled.remove(node.ch);
    }

    public Character firstNonRepeating() {
        // if head == tail 说明没有任何实际存在的node
        if (head == tail) {
            return null;
        }
        return head.next.ch;
    }

}
