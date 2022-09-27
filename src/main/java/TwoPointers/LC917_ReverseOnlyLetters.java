package TwoPointers;

public class LC917_ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        if (s.length() == 1) {
            return s;
        }
        int i = 0, j = s.length() - 1;
        char[] array = s.toCharArray();
        while (i < j) {
            if (!Character.isLetter(array[i])) {
                i++;
            }
            else if (!Character.isLetter(array[j])) {
                j--;
            }
            else {
                swap(array, i++, j--);
            }
        }
        return new String(array);
    }

    //  Character自带isLetter() method!
    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
