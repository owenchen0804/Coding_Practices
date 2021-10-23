package DIYStructure;

import java.util.Arrays;

public class MyHashMap {
    public static class Entry<String, Integer> {
        final String key;
        Integer value;
        public Entry<String, Integer> next;    // 每个entry应该都会有next就像Singly LL一样

        public Entry(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) { // 就对应这个entry的key来赋值
            this.value = value;
        }
    }

    private Entry<String, Integer>[] array;
    private int size;
    private float loadFactor;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int cap, float loadFactor) {
        if (cap <= 0) {
            throw new IllegalArgumentException("cap can not be <= 0");
        }
        array = (Entry<String, Integer>[]) new Entry[cap];
        //  这里array在new的时候不能加上<>generic type，只能在左边加括号然后强制转换！
        //  array = new Entry[cap];
        size = 0;
        this.loadFactor = loadFactor;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    private int hash(String key) {  // 主要作用是拿到非负的hashcode value
        if (key == null) {
            return 0;
        }
        return key.hashCode() & 0x7FFFFFFF;
        // hashCode()是Java自带的，和后者按位与保证remainder不为负数
    }

    private int getIndex(String key) {
        return hash(key) % array.length;
    }

    private boolean equalsValue(Integer v1, Integer v2) {
        return (v1 == v2) || (v1 != null && v1.equals(v2));
    }

    public boolean containsValue(Integer value) {
        if (isEmpty()) {
            return false;
        }
        for (Entry<String, Integer> entry: array) {
            while (entry != null) {
                if (equalsValue(entry.getValue(), value)) {
                    return true;
                }
                entry = entry.next;
            }
        }
        return false;
    }

    private boolean equalsKey(String k1, String k2) {
        return (k1 == k2) || (k1 != null) && k1.equals(k2);
    }

    public boolean containsKey(String key) {
        //  这里不同于value，通过key可以算出index，然后在对应的那个bucket里面的LL找！
            int index = getIndex(key);
            Entry<String, Integer> entry = array[index];    // 对应bucket的那个头结点就是entry
            while (entry != null) {
                if (equalsKey(entry.getKey(), key)) {
                    return true;
                }
                entry = entry.next;
            }

        return false;
    }

    public Integer get(String key) {
        //  key为null的情况，getIndex(null)是0，也就是bucket index == 0 的地方留给了唯一的null
//        if (key == null) {
//            return null;
//        }
        int index = getIndex(key);
        Entry<String, Integer> entry = array[index];
        while (entry != null) {
            if (equalsKey(entry.getKey(), key)) {
                return entry.getValue();
            }
            entry = entry.next;
        }
        return null;
    }

    public Integer put(String key, Integer value) {
        int index = getIndex(key);
        Entry<String, Integer> entry = array[index];
        while (entry != null) {
            if (equalsKey(entry.getKey(), key)) {
                Integer result = entry.value;
                entry.setValue(value);
                return result;
            }
            entry = entry.next;
        }
        // entry走到LL的尾端了还没有找到key，说明不在map里面，需要插入，我们一般在head头上插入
        //  原因是通常最近更新的key有可能在近期被频繁的用到
        Entry<String, Integer> newNode = new Entry<>(key, value);
        newNode.next = array[index];
        array[index] = newNode;
        size++;
        if (needRehashing()) {
            Rehashing();
        }
        return null;    // 正常插入新的元素，返回null
    }

    private boolean needRehashing() {
        float ratio = (size + 0.0f) / array.length;
        return ratio >= loadFactor;
    }

    private void Rehashing() {
        Entry<String, Integer>[] oldArray = array;
        array = (Entry<String, Integer>[]) new Entry[oldArray.length * 2];
        for (Entry<String, Integer> entry : oldArray) {
            while (entry != null) {
                int index = getIndex(entry.key);
                Entry<String, Integer> next = entry.next; //    要把原来旧的LL的下一个node先存起来！
                entry.next = array[index];  // 插在新LL的表头
                array[index] = entry;
                entry = next;
            }
        }
    }

    public Integer remove(String key) {
        int index = getIndex(key);
        Entry<String, Integer> entry = array[index];
        Entry<String, Integer> prev = null;
        while (entry != null) {
            if (equalsKey(entry.key, key)) {
                if (prev != null) {
                    prev.next = entry.next;
                }
                else {
                    array[index] = entry.next;  // 这是bucket的第一个就是要remove的，于是删掉头
                }
                size--; // 很重要！
                return entry.value;
            }
            prev = entry;
            entry = entry.next;
        }
        return null;    // map里面并没有这个key所以返回null
    }

}
