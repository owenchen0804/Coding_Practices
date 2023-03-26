package com.owen.Coding_Practices;

public class Test3 {
    public boolean primeSubOperation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                i--;
                continue;
            }
            int diff = nums[i] - nums[i + 1];
            boolean fixed = false;
            for (int j = diff + 1; j < nums[i]; j++) {
                fixed = false;
                if (isPrime(j)) {
                    nums[i] -= j;
                    fixed = true;
                    //  这里要加break!不然的话j还会往上加！
                }
            }
            if (fixed == false) {
                return false;
            }
            i--;
        }
        return true;
    }

    private boolean isPrime(int num) {

        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] array = {8,11,16,13};
        //System.out.print(Long.compare(a, 1));
        Test3 test = new Test3();
        test.primeSubOperation(array);
    }
}
