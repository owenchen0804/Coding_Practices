package String;

public class LA281_RemoveLeadingTrailingDuplicatedSpace {
    public String removeSpaces(String input) {
        if (input.isEmpty()) {
            return input;
        }
        char[] array = input.trim().toCharArray();
        //  String.trim()可以去除掉string开头和结尾的space，所以下面不用讨论这两种特殊情况
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
                //  用过了trim后就不用担心fast == 0的情况还是' '了
                continue;
            }
            array[slow++] = array[fast];
        }
        //  有可能全是space然后slow一直在0，所以array[slow - 1]可能是OOB
//        if (slow > 0 && array[slow - 1] == ' ') {
//            slow--;
//        }
        return new String(array, 0, slow);
    }
}
