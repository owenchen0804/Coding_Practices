package String;

public class LA79_RemoveAdjacentRepeatedCharacters {
    public String removeCharacters(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 1;   //  只留一个重复的，比如aaaaa -> a 所以第一个肯定是可以留下的，那么slow可以初始为1
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] == array[fast - 1]) {
                continue;
            }
            array[slow++] = array[fast];
        }
        return new String(array, 0, slow);

    }
}
