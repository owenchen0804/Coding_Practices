package RecursionIAndSorting;

import java.util.ArrayDeque;
import java.util.Deque;

public class LA279_SortWith3Stacks {
    public void sort(Deque<Integer> s1) {
        Deque<Integer> s2 = new ArrayDeque<>();
        Deque<Integer> s3 = new ArrayDeque<>();
        sort(s1, s2, s3, s1.size());
    }

    private void sort(Deque<Integer> s1, Deque<Integer> s2, Deque<Integer> s3, int length) {
        // base case 这里虽然用到的思想也是mergeSort，但是不像常规思路知道left, right，这里只能通过size来实现divide
        if (length <= 1) {
            return;
        }
        int mid1 = length / 2;
        int mid2 = length - length / 2;
        for (int i = 0; i < mid1; i++) {
            s2.offerFirst(s1.pollFirst());
        }
        sort(s2, s3, s1, mid1);
        sort(s1, s3, s2, mid2);
        int i = 0, j = 0;
        while (i < mid1 && j < mid2) {
            if (s2.peekFirst() < s1.peekFirst()) {
                s3.offerFirst(s2.pollFirst());
                i++;
            }
            else {
                s3.offerFirst(s1.pollFirst());
                j++;
            }
        }
        while (i < mid1) {
            s3.offerFirst(s2.pollFirst());
            i++;
        }
        while (j < mid2) {
            s3.offerFirst(s1.pollFirst());
            j++;
        }

        for (int index = 0; index < length; index++) {
            s1.offerFirst(s3.pollFirst());
        }
    }

    public static void main(String[] args) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        stack1.offerFirst(3);
        stack1.offerFirst(1);
        stack1.offerFirst(2);
        stack1.offerFirst(4);
        LA279_SortWith3Stacks test = new LA279_SortWith3Stacks();
        test.sort(stack1);
    }
}
