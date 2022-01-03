package StrongerIII;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LA133_MergeKSortedArrays {
    // 本题的思想还是K个array一起做谁小移谁，所以先要把每个array的第一个数放进minHeap中，
    // 然后poll出来之后作为全场最小，根据新建的Element拿到对应的行列信息，再在对应的位置往后移动指针
    public int[] merge(int[][] arrayOfArrays) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>((Element e1, Element e2) -> {
            if (e1.value == e2.value) {
                return 0;
            }
            return e1.value < e2.value ? -1 : 1;
        });
        int length = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            // 这里要考虑可能某一个array的length为0，所以可能arrayOfArrays[][]会OOB！
            int[] array = arrayOfArrays[i];
            // length += arrayOfArrays[i].length;
            length += array.length;
            // minHeap.offer(new Element(i, 0, arrayOfArrays[i][0]));
            if (array.length != 0) {
                minHeap.offer(new Element(i, 0, array[0]));
            }
        }
        int[] result = new int[length];
        int cur = 0;    // 谁小移谁的总坐标
        while (!minHeap.isEmpty()) {    // merge结束的终止条件
            Element temp = minHeap.poll();
            // 保证了这个是最小的，直接放入result
            // 接下来要做的就是确认temp所在的row/col然后继续放入新的数
            result[cur++] = temp.value;
            if (temp.col + 1 < arrayOfArrays[temp.row].length) {
                // 之前第0个元素都放进去了，这里判断到该数组的第倒数第二个
                // 如果能进入if，那么下面已经把该数组的最后一个元素放入minHeap了，不用再往前走
                temp.col++;
                temp.value = arrayOfArrays[temp.row][temp.col]; // 这里row不变，但是col/value要重新赋值！
                minHeap.offer(temp);
            }
        }
        return result;
    }

    static class Element {
        int row;
        int col;
        int value;
        public Element(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    static class myComparator implements Comparator<Element> {
        @Override
        public int compare(Element e1, Element e2) {
            if (e1.value == e2.value) {
                return 0;
            }
            return e1.value < e2.value ? -1 : 1;
        }
    }
}




