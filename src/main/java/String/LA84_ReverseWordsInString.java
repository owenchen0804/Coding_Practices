package String;

public class LA84_ReverseWordsInString {
    public String reverseWords(String input) {  // I love Yahoo => Yahoo love I
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i;
            }
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
                reverse(array, start, i);
            }
        }
        reverse(array, 0, array.length - 1);
        return new String(array);
    }

    private void reverse(char[] array, int i, int j) {
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}
