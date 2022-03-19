package Contest;

public class LC2207_MaximizeNumberOfSubsequencesInAString {
    public long maximumSubsequenceCount(String text, String pattern) {
        long result = 0, count0 = 0, count1 = 0;

        for (int i = 0; i < text.length(); i++) {
            //  这里有可能pattern的两个数都是相同的，所以不能用if/else，只能是2个if，
            //  并且要先看后面那个, 如果先看前面那个，result会多加了1次
            if (text.charAt(i) == pattern.charAt(1)) {
                result += count0;
                //  出现后一个char就要结算到result了，对于每一个新出现的后一个char,
                //  可以有前面count0这么多个和它组成一个符合要求的subsequence，要加到result里面去
                count1++;
                //  自己也需要加上，因为最后还要看单独再加一个到哪里
            }

            if (text.charAt(i) == pattern.charAt(0)) {
                count0++;   //  当只有前面一个char出来的时候，还不能加到result里面
            }

        }
        //  对于c0来说，当然是放在最开头比较好，这样可以多出来count1个
        //  对于c1来说，应该是放在最后比较好，可以多出来count0个
        //  所以实际上比较的就是count0和count1的大小
        return result + Math.max(count0, count1);
    }
}
