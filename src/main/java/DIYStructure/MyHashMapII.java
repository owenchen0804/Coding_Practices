package DIYStructure;

public class MyHashMapII {
    public static class Node<String, Integer> {
        final String key;
        Integer value;
        Node<String, Integer> next;
        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
        public String getKey() {
            return key;
        }
        public Integer getValue() {
            return value;
        }
        public void setValue(Integer value) {
            this.value = value;
        }
    }

    private Node<String, Integer>[] array;
    private int size;
    private float loadFactor;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public MyHashMapII() {this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);}
    public MyHashMapII(int cap, float loadFactor) {
        if (cap <= 0) {
            throw new IllegalArgumentException("cap can not be <= 0!");
        }
        array = (Node<String, Integer>[]) new Node[cap]; // 这里赋值new的右边没法给出<>，只能在new左边强制cast
        size = 0;
        this.loadFactor = loadFactor;
    }

    private int hash(String key) {
        if (key == null) {
            return 0;
        }
        return key.hashCode() & 0x7FFFFFFF;
    }

    private int getIndex(String key) {
        return hash(key) % array.length;
    }

    private boolean equalsKey(String s1, String s2) {
        return s1 == s2 || (s1 != null && s1.equals(s2));    // 只要s1不是null就可以执行s1.equals()
    }

    public boolean containsKey(String key) {
        int index = getIndex(key);
        Node<String, Integer> node = array[index];
        while (node != null) {
            if (equalsKey(key, node.key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private boolean equalsValue(Integer o1, Integer o2) {
        return o1 == o2 || ( o1 != null && o1.equals(o2));
    }

    public boolean containsValue(Integer value) {
        if (size == 0) {return false;}
        for (Node<String, Integer> node : array) {
            while (node != null) {
                if (equalsValue(node.value, value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public Integer get(String key) {
        //if (key == null) {
        //    return null;
        //}
        int index = getIndex(key);
        Node<String, Integer> node = array[index];
        while (node != null) {
            if (equalsKey(key, node.key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public Integer put(String key, Integer value) {
        int index = getIndex(key);
        Node<String, Integer> node = array[index];
        while (node != null) {
            if (equalsKey(key, node.key)) {
                Integer result = node.value;
                node.setValue(value);
                return result;
            }
            node = node.next;
        }
        //  走到这里说明没找到对应的key，于是需要插入到表头
        Node<String, Integer> newNode = new Node<>(key, value);
        newNode.next = array[index];
        array[index] = newNode;
        size++;
        if (size + 0.0f >= loadFactor) {
            rehashing();
        }
        return null;    // 插入新元素返回Null
    }

    private void rehashing() {
        Node<String, Integer>[] oldArray = array;
        array = (Node<String, Integer>[]) new Node[array.length * 2];
        for (Node<String, Integer> node : oldArray) {
            while (node != null) {
                Node<String, Integer> next = node.next;
                int index = getIndex(node.key);
                node.next = array[index];
                array[index] = node;
                node = next;
            }
        }
    }

    public Integer remove(String key) {
        int index = getIndex(key);
        Node<String, Integer> node = array[index];
        Node<String, Integer> prev = null;
        while (node != null) {
            if (equalsKey(key, node.key)) {
                if (prev != null) {
                    prev.next = node.next;
                }
                else {
                    array[index] = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

}


