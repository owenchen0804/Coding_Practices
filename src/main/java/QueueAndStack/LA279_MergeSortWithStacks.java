package QueueAndStack;

import java.util.LinkedList;

public class LA279_MergeSortWithStacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        LinkedList<Integer> s3 = new LinkedList<Integer>();
        // Write your solution here.
        if (s1.size() <= 1) {
            return;
        }
        // Sort elements in s1 using s2 as buffer and s3 as
        // temporary storage for the results
        // Specify the number of elements to get sorted in s1
        mergeSort(s1, s2, s3, s1.size());
    }

    private void mergeSort(LinkedList<Integer> s1,
                           LinkedList<Integer> s2, LinkedList<Integer> s3, int length) {
        if (length <= 1) {
            return; // base case
        }
        // Divide the input s1 into two halves and sort them respectively:
        // Put 1/2 of the elements in s1 to the buffer s2
        // Sort the elements in s1 and the transfered elements in s2
        int half = length / 2;
        for (int i = 0; i < half; i++) {
            s2.offerFirst(s1.pollFirst());
        }
        // There are (length - half) elements left in s1
        mergeSort(s1, s2, s3, length - half);
        //  此时s2也有half unsorted data，就把s2当成s1，原来的s1变成buffer，角色互换。
        mergeSort(s2, s1, s3, half);
        // Merge the newly sorted part in s1 and s2 into s3
        merge(s1, s2, s3, length - half, half);
        // Transfer the sorted part from s3 back to s1
        move(s3, s1, length); // 当时sort的长度，而不是总长度！
    }

    private void merge(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3,
                       int length1, int length2) {
        // Put the smaller number in s1 and s2 into s3 first
        // Such that s3 will have the elements sorted in
        // descending order from top to bottom
        int one = 0, two = 0;
        while (one < length1 && two < length2) {
            if (s1.peekFirst() <= s2.peekFirst()) {
                s3.offerFirst(s1.pollFirst());
                one++;
            }
            else {
                s3.offerFirst(s2.pollFirst());
                two++;
            }
        }
        while (one < length1) {
            s3.offerFirst(s1.pollFirst());
            one++;
        }
        while (two < length2) {
            s3.offerFirst(s2.pollFirst());
            two++;
        }
    }

    private void move(LinkedList<Integer> src, LinkedList<Integer> dest, int length) {
        for (int i = 0; i < length; i++) {
            dest.offerFirst(src.pollFirst());
        }
    }
}
