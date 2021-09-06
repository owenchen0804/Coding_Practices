package Heap_BFS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LA25_KSmallestInUnsortedArray {

    //1. minHeap 需要对整体heapify之后再pop k次, offline算法
    //    TC: O(n) + k log n
    //2. maxHeap  只建立size = k 的heap, O(k), online算法后面可以持续进入数字，只有比堆顶的元素小才能进堆
    //    TC: O(k) + n log k
    //   以上两种不太好比较大小，但是online算法更灵活

    public int[] kSmallestI(int[] array, int k) {
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 > o2 ? -1 : 1;
            }
        });

        for (int i = 0; i < k; i++) {
            maxHeap.offer(array[i]);
        }

        for (int i = k; i < array.length; i++) {
            if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
       return result;
    }

    // 3. Quick Select 和quick sort在find pivot类似，
    //  TC: in average O(n), worst O(n^2)
    public int[] quickSelect(int[] array, int k) {
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        quickSelect(array, k, 0, array.length - 1);
        //  完成quickSelect后锁定前k个数，但是要copy到result里面
        int[] result = Arrays.copyOf(array, k);
        //  quickSelect只能保证是前k小的，但是不保证顺序，所以需要sort
        Arrays.sort(result);
        return result;
    }

    private void quickSelect(int[] array, int target, int left, int right) {
        int pivotIndex = partition(array, left, right);
        if (pivotIndex == target) {
            return;
        }
        if (pivotIndex < target) {
            quickSelect(array, target, pivotIndex + 1, right);
        }
        else {
            quickSelect(array, target, left, pivotIndex - 1);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left, j = right - 1;
        while (i <= j) {
            if (array[i] < pivot) {
                i++;
            }
            else if (array[j] >= pivot) {
                j--;
            }
            else {
                swap(array, i++, j--);
            }
        }
        swap(array, i, right);
        return i;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}