package TwoPointers;

public class LC42_TrappingRainWater {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int leftMax = 0, rightMax = 0;
        //  要记录左右挡板的最高点，当发现当前的height更小的时候才可以加到max
        //  只要发现更高的挡板的时候也需要更新挡板最高点
        //  右边的挡板也是一样
        //  leftMax:  needs to be updated -> 找到更高的一个挡板
        //  rightMax: needs to be updated -> 找到更高的一个挡板
        //  update solution(anw) -> 当遇到比leftMax/rightMax小的height的时候说明能存到水
        //  heights[left] 和 heights[right]每次遍历的时候都会指到新的位置
        //  遍历heights的时候，我们要做:
        //  1. 更新左右挡板的条件:
        //      a. heights[left] >= leftMax ->  更新leftMax
        //      b. heights[right] >= rightMax -> 更新rightMax
        //  2. 更新完挡板后，注意也是要比较leftMax和rightMax，对较小的的进行计算加入到max
        int max = 0;
        while (i <= j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax) {
                // 当前的i上面能trap到短板的高度
                // i右边的板子对于i的高度不造成任何影响
                max += leftMax - height[i];
                i++;
            }
            else {
                max += rightMax - height[j];
                j--;
            }
        }
        return max;
    }
}
