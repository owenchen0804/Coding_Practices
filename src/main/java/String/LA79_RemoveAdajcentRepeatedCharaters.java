package String;

public class LA79_RemoveAdajcentRepeatedCharaters {
    public String removeCharacters(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 1;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] == array[fast - 1]) {
                continue;
            }
            array[slow++] = array[fast];
        }
        return new String(array, 0, slow);

    }
}
