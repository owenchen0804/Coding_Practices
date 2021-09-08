package DIYStructure;

public class LA613_DesignCircularDeque {
    private int head;
    private int tail;
    private int size;
    private int[] array;

    public LA613_DesignCircularDeque(int k) {
        //  注意这里的k是传给constructor内部可见的变量，在其他api中k不可见!

        // 因为insertFirst和insertLast都要赋值，如果head = tail = 0的话，
        // 比如先启动insertLast再insertFirst相当于后者把前者的值就给overwrite了，
        // 所以应该可以设定head = 0, tail = 1, size = 0
        head = 0;
        //  tail = 0;
        tail = 1;
        size = 0;
        array = new int[k];
    }

    public boolean insertFront(int value) {
        if (size == array.length) {
            return false;
        }
        head = head == 0 ? array.length - 1 : head - 1;
        array[head] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == array.length) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        head = (head + 1) % array.length;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        tail = tail == 0 ? array.length - 1 : tail - 1;
        size--;
        return true;
    }

    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return array[(head + 1) % array.length];    // head本身不指向任何data,它的后一位才是
    }

    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return tail == 0 ? array[array.length - 1] : array[tail - 1];
        //  tail本身不指向任何data, 它的前一位才是
    }
}