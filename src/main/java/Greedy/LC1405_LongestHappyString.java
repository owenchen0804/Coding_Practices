package Greedy;

public class LC1405_LongestHappyString {
    /*
    The idea behind this problem
    1. Here we start by taking the size as the sum of a, b, c.
    2. Then we use 3 variables A, B, C to count the occurance of a, b, c.
    3. Now we iterate until the size, and
    -> Checks the largest number among a, b, c and whether the count < 2 or whther the count of other letters is 2 and there is still letters that can be added, then we append the letter, decrement from the total count of that particular letter and increase the occurance of that letter and set others back to zero.

    4. Finally return the string.
*/
    public String longestDiverseString(int a, int b, int c) {
        int totalSize = a + b + c;
        int A = 0, B = 0, C = 0;    //  表示A,B,C已经分别连续多少个了
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalSize; i++) {
            //  checks a is largest and its count still < 2 or B and C =2 and there are still a that can be added
            if ((a >= b && a >= c && A < 2) || (B == 2 && a > 0) || (C == 2 && a > 0)) {
                sb.append("a");
                A += 1;
                a -= 1;
                B = 0;  //  连续b的个数reset为0
                C = 0;  //  连续c的个数reset为0
            }
            //  三种情况是互斥的，i++下一次循环后继续他欧尼
            else if ((b >= a && b >= c && B < 2) || (A == 2 && b > 0) || (C == 2 && b > 0)) {
                sb.append("b");
                B += 1;
                b -= 1;
                A = 0;
                C = 0;
            }
            else if ((c >= a && c >= b && C < 2) || (A == 2 && c > 0) || (B == 2 && c > 0)) {
                sb.append("c");
                C += 1;
                c -= 1;
                A = 0;
                B = 0;
            }

        }
        return sb.toString();
    }
}
