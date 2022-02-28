package DIYStructure;

import java.util.HashMap;
import java.util.Map;

public class LA205_LRUCache<K, V> {
    //  each node contains key and value pair, and it must be a DLL
    static class Node<K, V> {
        Node<K, V> prev;
        Node<K, V> next;
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        void update(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    //  make it final for the pre-defined size limit of the Cache
    private final int limit;
    //  record all the time the head and tail of the DLL
    private Node<K, V> head;
    private Node<K, V> tail;
    //  Need to maintain the relationship of key and its corresponding node in the DLL
    private Map<K, Node<K, V>> map; // HashMap里面的值是整个node

    // constructor
    public LA205_LRUCache(int limit) {
        this.limit = limit;
        this.map = new HashMap<K, Node<K, V>>();
    }

    public void set(K key, V value) {
        Node<K, V> node = null;
        if (map.containsKey(key)) {
            // 如果本来就有，那么要更新值，并且放到head表示刚Update过
            node = map.get(key); // 先指向它然后remove
            remove(node);
        }
        else if (map.size() < limit) {
            //  map的空间还有，所以不用去掉tail的node
            node = new Node<K, V>(key, value);
        }
        else {
            // map的size达到了limit，所以要把tail对应的node去掉再来append
            node = tail;
            remove(node);
            //  现在可以更新值
            node.update(key, value);
        }
        append(node); // 所有的情况最后都要放在head的
    }

    private Node<K, V> remove(Node<K, V> node) {
        map.remove(node.key, node);
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }
}
