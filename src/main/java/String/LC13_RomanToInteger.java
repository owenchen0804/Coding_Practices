package String;

public class LC13_RomanToInteger {
    public int romanToInt(String s) {
        //  思路是先把s中的每个字母都对应到一个具体的数字，然后要跟罗马数字的特性，在下一个代表数字比当前代表数字
        //  大的时候要把当前的数字减掉，再加上后面的，比如IV，相当于是-1 + 5 = 4这样

        int[] nums = new int[s.length()];
        //  首先把s中每个字母对应成数字
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    nums[i] = 1;
                    //  填好数字后就什么也不做，继续下一个i
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'M':
                    nums[i] = 1000;
                    break;
            }
        }

        //  接下来就是对于nums[]进行iterate，然后把所有右边比当前数字大的要减去
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                result -= nums[i];
            }
            else {
                result += nums[i];
            }
        }
        return result + nums[nums.length - 1];
    }
}
