package DPI;

//  1. 切绳子，必须至少切一刀，所以M[2]就为1，因为一种切法一刀两断，左大段=右小段=1，乘积为1。
//  2. M[4]的最大值发生在2*2 也就是i=4， j=2 的时候：
//  Math.max(2, M[2] ) * (i - j)
//  2和M2取最大值应该是2，也就是左大段不切的情况下是最大的，但是它满足了至少切一刀，因为已经分成了左右两段.
//  注意！左大段的意思是我们通过查表得到的之前计算过的结果，比如这时候M[2] = 1是我们查表得知的！！
//  但是还要考虑左大段不切的情况，比如这里不切的2，就比M[2]大。
//  3. 切字典那道题则是把左大段不切剩下都是右小段考虑到了第二个for循环里面，所以j可以从0开始，
//  那么右边自然就是i-j了也就是input.substring(j, i)而这里j正好为0
//  4.这道题的M[i]表示对长度为i的绳子切至少一刀，最大的product是多少。所以当index = i在扫描的时候，
//  只需要看左大段查表得到M[j](j < i)的值，和左大段完全不切就是j来比较，取更大值，然后右小段是i - j，
//  需要manually写出来，再和前面的最大值求出乘积，并且要把所有index = i, 然后j变化得出的乘积取一个最大值填表，
//  也就是赋值给M[i]

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
                //  需要往回看每一个小于i的j组合的结果，所以必须要开M[]大小
                curMax = Math.max(curMax, Math.max(j, M[j]) * (i - j));
                // M[i]是由这些比它小的j numbers里面选取一个相乘最大值拿到的
            }
            M[i] = curMax;
        }
        return M[n];
    }
}
// Time: O(N^2)
