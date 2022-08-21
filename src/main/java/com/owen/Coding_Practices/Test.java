package com.owen.Coding_Practices;

import java.util.*;
import LinkedList.*;

public class Test{

    public String largestPalindromic(String num) {
        if (num.length() == 1) return num;
        int[] count = new int[10];
        for (char c : num.toCharArray()) {
            count[c - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        boolean findMiddle = false;
        char middle = '0';
        for (int i = 9; i >= 0; i--) {
            if (count[i] == 0) {
                continue;
            }
            if (!findMiddle && count[i] % 2 == 1) {
                middle = (char) ('0' + i);
                findMiddle = true;
                if (count[i] != 1) {
                    int times = count[i] / 2;
                    for (int j = 0; j < times; j++) {
                        sb.append((char) (i + '0'));
                    }
                }
                //  如果为1的话就只能放到中间，或者就不要了
            }
            else {
                //  偶数
                int times = count[i] / 2;
                for (int j = 0; j < times; j++) {
                    sb.append((char) (i + '0'));
                }
            }
        }

        //  如果前缀都是0的话要去掉
        int index = 0;
        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }

        for (int i = 0; i < index; i++) {
            sb.deleteCharAt(i);
        }


        if (findMiddle) {
            return sb.toString() + Character.toString(middle) + sb.reverse().toString();

        }
        return sb.toString() + sb.reverse().toString();
    }

    public static void main(String[] args) {
        Test test = new Test();
        String s = "00009";
        test.largestPalindromic(s);
    }
}