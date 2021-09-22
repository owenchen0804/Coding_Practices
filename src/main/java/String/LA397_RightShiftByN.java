package String;

public class LA397_RightShiftByN {
    // Assumption: input is not null and n >= 0
    public String rightShift(String input, int n) {
        if (input.length() <= 1 || n == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        n = n % array.length;
        reverse(array, 0, array.length - n - 1);
        reverse(array, array.length - n, array.length - 1);
        reverse(array, 0, array.length - 1);
        return new String(array);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
