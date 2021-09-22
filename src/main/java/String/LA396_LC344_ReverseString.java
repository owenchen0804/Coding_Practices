package String;

public class LA396_LC344_ReverseString {
    public String reverseString(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int i = 0, j = array.length - 1;
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return new String(array);
    }
}
