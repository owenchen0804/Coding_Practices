package Array;

public class LC849_MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] seats) {
        // 至少有1个1，和1个0
        // 如果正好就2个数，那么直接return 1
        if (seats.length == 2) {
            return 1;
        }
        // 接下来可以用slow/fast记录相邻两个1的位置，算index差值，找到最大的index差值，最后/2就行了
        //  int slow = -1, fast = -1;
        int firstOne = -1, lastOne = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                // 第1个1到index 0 的位置 这个要记住！因为它到0的距离不用/2 !!
                firstOne = i;
                break;
            }
        }
        int slow = firstOne;    // 记录一个slow，作为和后面的1之间计算的变量

        // 同时还要记住lastOne!!
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                lastOne = i;
                break;
            }
        }

        // 如果从前往后和从后往前数1的index一致，那么整个seats[]有且只有一个1
        if (firstOne == lastOne) {
            return Math.max(firstOne, seats.length - 1 - firstOne); // 看firstOne离seats[]的起止点哪个更远
        }

        // 如果多于1个1，那么首先要看firstOne和lastOne谁距离起/终点更远
        int distance = Math.max(firstOne, seats.length - 1 - lastOne);

        // 之后的在多个1之间的距离用maxSpacing来维护
        int maxSpacing = 0;

        for (int j = firstOne + 1; j < seats.length; j++) {
            if (seats[j] == 1) {
                int fast = j;
                maxSpacing = Math.max(maxSpacing, fast - slow);
                slow = fast;
            }
        }

        // 不止1个1，那么fast肯定有值，并且完成了increasingly update
        return distance > maxSpacing / 2 ? distance : maxSpacing / 2;
    }
}
