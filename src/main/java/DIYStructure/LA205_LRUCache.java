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

    
}
