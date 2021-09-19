package String;

public class LA281_RemoveLeadingTrailingDuplicatedSpace {
    public String removeSpaces(String input) {
        if (input.isEmpty()) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
                continue;
            }
            array[slow++] = array[fast];
        }
        //  有可能全是space然后slow一直在0，所以array[slow - 1]可能是OOB
        if (slow > 0 && array[slow - 1] == ' ') {
            slow--;
        }
        return new String(array, 0, slow);
    }
}
