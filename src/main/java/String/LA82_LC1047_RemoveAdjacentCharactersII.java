package String;

public class LA82_LC1047_RemoveAdjacentCharactersII {
    public String removeCharacters(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;   //  对于本题是先移动slow，再赋值，所以结果是包括slow在内的闭区间
        for (int fast = 1; fast < array.length; fast++) {
            if (slow == -1 || array[fast] != array[slow]) {
                array[++slow] = array[fast];
            }
            else {
                slow--;
                //  不仅如此，还要消消乐，把所有后面也是array[fast]的消掉
                while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
                    fast++; //所有同样的字母全部消掉
                }
            }
        }
        return new String(array, 0 , slow + 1);
    }
}
