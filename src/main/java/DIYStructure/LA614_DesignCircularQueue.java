package DIYStructure;

public class LA614_DesignCircularQueue {
    private int head;
    private int tail;
    private int size;
    private int[] array;

    public LA614_DesignCircularQueue(int k) {
        head = 0;
        tail = 0;
        size = 0;
        array = new int[k];
    }

    public boolean enQueue(int value) {
        if (size == array.length) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    public boolean deQueue() {
        // 如果顺利的话，数字从前面出，那么head也应该右移
        if (size == 0) {
            return false;
        }
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
        //  注意tail处是不存东西的，它前面一个index才是最后一个data，所以要按照tail是否为0来讨论
        if (size == 0) {
            return -1;
        }
        return tail == 0 ? array[array.length - 1] : array[tail - 1];
    }
}