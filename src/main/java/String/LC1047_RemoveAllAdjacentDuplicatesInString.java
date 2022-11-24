package String;

public class LC1047_RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        //  消消乐，需要模拟一个像stack一样工作的双指针
        //  这道题不是把所有相同的全部消掉，而是只消除2个！
        //  不能只靠移动指针，还需要把要保留的部分copy到result array里面！
        int slow = -1, fast = 0;
        //  slow includes the result
        char[] array = s.toCharArray();
        while (fast < s.length()) {
            if (slow == -1 || array[slow] != array[fast]) {
                slow++;
                array[slow] = array[fast++];
            }
            else {
                //  就是没有下面这个一直消消乐的while循环了
                //  while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
                //      fast++; //所有同样的字母全部消掉
                //  }
                fast++;
                slow--;
                //  当发现array[slow] == array[fast]的时候
                //  fast往前跳一个，slow往回走一个，就相当于是消掉了两个重复的
            }
        }
        return new String(array, 0, ++slow);
    }
}
