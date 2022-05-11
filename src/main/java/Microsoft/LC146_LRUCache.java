package Microsoft;
//

import java.util.HashMap;
import java.util.Map;

public class LC146_LRUCache {
    private static class Node {
        Node prev;
        Node next;
        int key;
        int value;
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
        void update(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private Map<Integer, Node> map;
    //  为什么需要这样设计map里面的key-value pair?
    //  因为LRU需要DLL来维护被visit的值的先后顺序，所以必然需要一个internal class Node来互相链接
    //  Node自身带有key, value才能保证数据是一体的
    //  而map需要保存key能在O(1)找到，所以必须要这么存，map<key, value>是没用的，因为没有Node

    private Node head;
    private Node tail;
    LC146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        append(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            remove(node);   //  由于这里的key本来就存在，所以更新的时候只是改变了value
            //  对应的key先删掉，再更新value，再append，这样和先更新value，再删掉key, 再append同样的key
            //  本质上没有区别，所以这里唯一可以互换顺序的地方就是因为key始终没有变
            node.update(key, value);
        }
        else if (map.size() < capacity) {
            node = new Node(key, value);
        }
        else {
            node = tail;
            remove(node);
            node.update(key, value);
            //  capacity满了就只能在tail处重新更新node，就和前面containsKey(key)
            //  的情况很类似，只是上面会先找到key所在的位置进行更新，这个一定是在tail处更新
            //  remove(node);
            //  如果先update node，那么node.key就变了，比如原来node=(2,2)，然后通过调用update()
            //  node变成了(3,3)；但是！！在map里面，对应的key = 2的这个entry没有删掉！不仅没有删掉
            //  里面的key-value pair变成了(2, node(3,3))!!这就是大问题！
            //  后面再remove(node), append(node) 也就是在map里面多加了一个(3, (3,3))
            //  这样map的size也发生了变化，之前的key=2的entry也还在，就会出问题了。
        }
        append(node);
    }

    private void remove(Node node) {
        map.remove(node.key);
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        //  还要处理一下如果正好node指向head or tail的情况
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.prev;
        }
        node.next = null;
        node.prev = null;
    }

    private void append(Node node) {
        map.put(node.key, node);
        if (head == null) { // DLL是空的，那么head == tail == null
            head = tail = node;
        }
        else {
            //  插入node在头结点
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public static void main(String[] args) {
        LC146_LRUCache test = new LC146_LRUCache(2);
        test.put(1, 1);
        test.put(2, 2);
        test.get(1);
        test.put(3, 3);
        test.get(2);
    }
}
