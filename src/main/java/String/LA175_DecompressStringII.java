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
            //  开头第一个一定是一个字母，直接append先，再讨论后面是否数字为0
                sb.append(array[i++]);
                int start = i;  // 这里i一直往前走比较好，每次while进来后start通过=i来更新值
                while (i < array.length && Character.isDigit(array[i])) {
                    i++;
                }
                // 跳出来说明i对应的character已经不再是数字了，而是新的字母，可以进入新的循环被再次append了
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
