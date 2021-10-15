package com.owen.Coding_Practices;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IteratorTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }
        for (ListIterator<Integer> iter = list.listIterator(); iter.hasNext();) {
            System.out.println("One step forward: " + iter.next());
            if (iter.hasNext()) {
                System.out.println("Another step forward: " + iter.next());
                System.out.println("Last step backward: " + iter.previous());
            }
        }
    }
}
