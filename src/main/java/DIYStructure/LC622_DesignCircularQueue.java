package DIYStructure;

public class LC622_DesignCircularQueue {
    //  考虑用array来实现，需要有head, tail, size
    private int head;
    private int tail;
    private int size;
    private int[] array;

    public LC622_DesignCircularQueue(int k) {
        //  初始化时head和tail都指向index = 0
        head = 0;
        tail = 0;
        size = 0;
        array = new int[k];
    }

    public boolean enQueue(int value) {
        if (size == array.length) {
            return false;
        }
        //  新来的value直接放在当前的tail上，然后tail理论上向后移动1个
        //  注意是circular的，所以tail在enQueue结束后的下一个index也可能会到head去
        array[tail] = value;
        size++;
        tail = (tail + 1) % array.length;
        // 可能tail本来就在2，head deQueue，然后tail跑到了Index = 0
        return true;
    }

    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        //  head右移，也就是把之前head指向的value扔出去
        head = (head + 1) % array.length;
        size--;
        return true;
    }

    public int Front() {
        if (size == 0) {
            return -1;
        }
        return array[head];
    }

    public int Rear() {
        if (size == 0) return -1;
        //  tail本身不存值，所以要返回tail前面的那个元素
        return tail == 0 ? array[array.length - 1] : array[tail - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
