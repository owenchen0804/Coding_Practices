package String;

public class LC151_ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] array = s.trim().toCharArray();
        //  注意本题是给定的s可能前后都有空格，所以要trim()
        //  另外word和word之间可能有大于1个空格，因此在全部完成翻转之后要按照之前的remove duplicate spaces
        //  的方法再做一次scan，所以还是需要在char[] array上用快慢指针操作一下
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i;
            }
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
                Reverse(array, start, i);
            }
        }
        Reverse(array, 0, array.length - 1);
        int slow = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ' && array[i + 1] == ' ') {
                continue;
            }
            array[slow++] = array[i];
        }
        return new String(array, 0, slow);
    }

    private void Reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
