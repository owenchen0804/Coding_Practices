package com.owen.Coding_Practices;

import java.util.*;
import LinkedList.*;

public class Test{
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int left = 0, right = n - 1;
        int up = 0, down = m - 1;
        int[][] result = new int[m][n];
        for (int[] res : result) {
            Arrays.fill(res, -1);
        }
        while (head != null) {
            for (int i = left; i <= right; i++) {
                if (head == null) {
                    break;
                }
                else {
                    result[up][i] = head.value;
                    head = head.next;
                }
            }
            up++;
            for (int i = up; i <= down; i++) {
                if (head == null) {
                    break;
                }
                else {
                    result[right][i] = head.value;
                    head = head.next;
                }
            }
            right--;
            for (int i = right; i >= left; i--) {
                if (head == null) {
                    break;
                }
                else {
                    result[down][i] = head.value;
                    head = head.next;
                }
            }
            down--;
            for (int i = down; i >= up; i--) {
                if (head == null) {
                    break;
                }
                else {
                    result[left][i] = head.value;
                    head = head.next;
                }
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(2);

        ListNode l4 = new ListNode(6);

        ListNode l5 = new ListNode(8);

        ListNode l6 = new ListNode(1);

        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        Test t = new Test();
        t.spiralMatrix(3, 5, l1);




    }
}