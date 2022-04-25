package DIYStructure;

import java.util.Arrays;
import java.util.NoSuchElementException;

//  如果是Heap Sort的话，思路是：
//  要建立一个maxHeap，用heapify()的方式，每次做percolateDown()
//  完成后堆顶是最大值，把它swap到array的最后，就是最大值
//  size--；然后继续heapify()，又得到新的堆顶元素作为最大值再swap到倒数第二的位置，如此往复

public class MinHeap {
    private int[] array;
    private int size;
    public MinHeap(int[] array) {// 一种constructor是给一个array
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input array cannot be null or empty");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    private void heapify() {
        //  每一个带孩子的元素都可能需要往下挪位置，尾元素坐标size - 1, 所以最后一个带孩子的坐标就是
        //  (size - 1 - 1) / 2 => size/2-1
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public MinHeap(int cap) {// 另一种constructor方式是给一个capacity新建一个array
        if (cap <= 0) {
            throw new IllegalArgumentException("capacity cannot be <= 0");
        }
        array = new int[cap];
        size = 0;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    private void percolateUp(int index) {
        while (index > 0 ) {// 只有index == 0的时候parentIndex才有可能OOB，而此时已经跳出循环了。
            int parentIndex = (index - 1) / 2;
            if (array[index] > array[parentIndex]){
                swap(index, parentIndex);
            }
            else {
                break;
            }
            index = parentIndex;
        }
    }

    private void percolateDown(int index) {
        while (index <= size / 2 - 1) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            int swapCandidate = leftChildIndex; // 因为当index == size / 2 - 1时，正好leftChildIndex = size - 1
            //  不一定！比如size = 3 [0, 1, 2]; parentIndex = 0, 但是leftChildIndex = 1 != size - 1!
            //  但是适用于size = 2 [0, 1]的情况，所以anyway不管怎样左孩子一定都在，右孩子则不一定，所以swapCandidateIndex
            //  默认值为左孩子方便讨论!
            //  也就是array的最后一个，此时还有可能和左孩子换，但是右孩子已经出界了。
            //  所以默认swapCandidate是左孩子比较容易做分情况讨论
            if (rightChildIndex <= size - 1 && array[rightChildIndex] < array[leftChildIndex]) {
                swapCandidate = rightChildIndex;
            }
            if (array[index] > array[swapCandidate]) {
                swap(index, swapCandidate);
                index = swapCandidate;
            }
            else {
                break;
            }

        }
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        return array[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        int result = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return result;
    }

    public void offer(int ele) {
        if (size == array.length) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5));
        }
        array[size] = ele;
        size++;
        percolateUp(size - 1);
    }

    public int update(int index, int ele) {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("invalid index range");
        }
        int result = array[index];
        array[index] = ele;
        if (result <= ele) {
            percolateDown(index);
        }
        else {
            percolateUp(index);
        }
        return result;
    }


    private void swap(int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
}
