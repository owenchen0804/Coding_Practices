package com.owen.Coding_Practices;

import java.util.Arrays;

public class Test1 {
    public static void f(int[] z, int y) {
        for (int i = 0; i < z.length; i++) {
            z[i] += y;
        }
        y *= 2;
        System.out.print(Arrays.toString(z) + ", ");
    }
    public static void main(String[] args) {
        int[] x = {5, 6, 7};
        int y = 4;
        f(x, y);
        System.out.print(Arrays.toString(x) + ", " + y);


    }
}
