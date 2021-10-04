package DPI;

public class LA87_MaxProductOfCuttingRope {
    public int cutRope(int n) {
        int[] M = new int[n + 1];
        // M[i] 代表当绳子为i meters long的时候的max product
        // 后面在算M[i]的时候需要用到前面的M[j]
        M[0] = 0;
        M[1] = 0; // invalid
        int maxProduct = 0;
        // 把绳子分为左大段left big section，剩下的叫右小段
        // 左大段i可以通过对所有比它小的j的M[j]值查表获得，而不是每次调用函数本身，右边则是余下的值，也不需要调用函数
        for (int i = 2; i <= n; i++) {
            // Build from i meters long rope
            int curMax = 0;
            for (int j = 1; j < i; j++) {   // j represents LeftBigSection
                curMax = Math.max(curMax, Math.max(j, M[j]) * (i - j));
                // M[i]是由这些比它小的j numbers里面选取一个相乘最大值拿到的
            }
            M[i] = curMax;
        }
        return M[n];
    }
}
// Time: O(N^2)
