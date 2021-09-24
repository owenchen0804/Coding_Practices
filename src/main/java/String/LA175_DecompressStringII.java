package String;

public class LA175_DecompressStringII {
    public String decompressII(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < array.length) {
            // if (!Character.isDigit(array[i])) { // it must be a letter
                sb.append(array[i]);
                int start = i;
                while (i + 1 < array.length && Character.isDigit(array[i + 1])) {
                    i++;
                }
                int count = getCount(array, start + 1, i);
                if (count == 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                else {
                    for (int j = 0; j < count - 1; j++) {
                        sb.append(array[start]);
                    }
                }
                i++;
        }
        return sb.toString();
    }

    private int getCount(char[] array, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            count = count * 10 + (array[i] - '0');
        }
        return count;
    }

    public static void main(String[] args) {
        LA175_DecompressStringII test = new LA175_DecompressStringII();
        System.out.println(test.decompressII("b5c0a1"));
        String test2 = "abcde";
        System.out.println(test2.substring(2));
        System.out.println(test2.substring(2,3));
        System.out.println(1 << 4 - 1); // "-"的运算优先级在<<的前面！
    }
}
