package com.owen.Coding_Practices;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Test2 {
    private int[] array;
    private int size;
    public Test2(int cap) {
        array = new int[cap];
        size = 0;
    }

    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (array[index] < array[parentIndex]) {
                swap(index, parentIndex);
                index = parentIndex;
            }
            else {
                break;  // 不需要再走while循环了，直接退出
            }
        }
    }

    public void percolateDown(int index) {
        while (index <= size / 2 - 1) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            int swapCandidate = leftChildIndex;
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
            throw new NoSuchElementException();
        }
        return array[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException();
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
            throw new ArrayIndexOutOfBoundsException();
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
