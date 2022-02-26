package DIYStructure;

public class MyHashMapIII {
    static class Entry<String, Integer> {
        final String key;
        Integer value;
        public Entry<String, Integer> next;

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

        public void setValue(Integer value) {
            this.value = value;
        }
    }

    private Entry<String, Integer>[] array;
    private int size;
    private float loadFactor;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    // constructors
    public MyHashMapIII() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);    // 用default值调用出下面的constructor
    }

    public MyHashMapIII(int cap, float loadFactor) {
        if (cap <= 0) {
            throw new IllegalArgumentException("Capacity cannot be <= 0 !");
        }
        array = (Entry<String, Integer>[]) new Entry[cap];
        size = 0;
        this.loadFactor = loadFactor;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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
        return s1 == s2 || (s1 != null && s1.equals(s2));
    }

    private boolean equalsValue(Integer i1, Integer i2) {
        return i1 == i2 || (i1 != null && i1.equals(i2));
    }

    public boolean containsKey(String key) {
        int index = getIndex(key);
        Entry<String, Integer> entry = array[index];
        while (entry != null) {
            if (equalsKey(entry.key, key)) {
                return true;
            }
            entry = entry.next; // 找到对应的bucket后不断往后找
        }
        return false;
    }

    public boolean containsValue(Integer value) {
        // 没有index可以得到，只能一个个bucket的找过去
        if (isEmpty()) {
            return false;
        }
        for (Entry<String, Integer> entry : array) {
            while (entry.value != null) {
                if (equalsValue(entry.value, value)) {
                    return true;
                }
                entry = entry.next;
            }
        }
        return false;
    }

    public Integer get(String key) {
        //  key是null的时候，通过getIndex()得到0，也会map到bucket = 0的那个Null
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
                int result = entry.getValue();
                entry.setValue(value);
                return result;
            }
            entry = entry.next;
        }
        // 走到这里，说明没有对应的key，那么久新建一个，并且放在LL的head
        Entry<String, Integer> newNode = new Entry<>(key, value);
        newNode.next = array[index];
        array[index] = newNode;
        size++; // 很重要！
        if (needRehashing()) {
            Rehashing();
        }
        return null; // 正常插入值，返回Null
    }

    public Integer remove(String key) {
        int index = getIndex(key);
        Entry<String, Integer> entry = array[index];
        Entry<String, Integer> prev = null;
        while (entry != null) {
            if (equalsKey(entry.getKey(), key)) {
                Integer result = entry.getValue();
                if (prev == null) {
                    array[index] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                return result;
            }
            // 如果不相等，就prev, entry继续往后挪
            prev = entry;
            entry = entry.next;
        }
        return null;
    }

    private boolean needRehashing() {
        float ratio = (size + 0.0f) / array.length;
        return ratio >= loadFactor;
    }

    private void Rehashing() {
        Entry<String, Integer>[] oldArray = array;
        //  下面这里很重要，因为array的size变化了，下面getIndex()得到的结果也会不一样
        array = (Entry<String, Integer>[]) new Entry[oldArray.length * 2];
        for (Entry<String, Integer> entry : oldArray) {
            while (entry != null) {
                int index = getIndex(entry.getKey());
                Entry<String, Integer> next = entry.next;
                entry.next = array[index];
                array[index] = entry;
                entry = next;
            }
        }
    }
}
