package String;

public class LA611_CompressStringII {
    public String compress(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        // Step1. Handle occurrence >= 2
        int slow = 0;
        int newLen = 0;
        int fast = 0;
        while (fast < array.length) {   // 不能是for循环，因为fast会在新的character停下来，不能自动再fast++
            int begin = fast;
            while (fast < array.length && array[fast] == array[begin]) {
                fast++;
            }
            array[slow++] = array[begin];    // 不管出现几次，这个character先写到slow对应的index上
            if (fast - begin == 1) {    // will be handled by Step2
                newLen += 2;    // 比如abc => a1b1c1 需要占用2位
            }
            else {  // handle occurrence >=2 比如 aaa => a3
                int len = copyDigit(array, slow, fast - begin); // 从slow开始要写入具体的数值！且可能不止1位
                slow += len; // 写入是在copyDigit()里，所以写完了要跳过去
                newLen += len + 1; // 对应的character + 重复次数
            }
        }

        char[] result = new char[newLen];
        slow = result.length - 1;
        fast = slow - 1;
        while (fast >= 0) {
            if (Character.isDigit(array[fast])) {
                while (fast >= 0 && Character.isDigit(array[fast])) {// 如果一直是数字就一直copy
                    result[slow--] = array[fast--];
                }
            }
            else {
                result[slow--] = '1';
            }
            // 这里很巧妙，比如ab12,从右往左输入2->1->之后发现是b，于是会跳出里面的while循环
            //  然后也会跳过上面的else，到下面把b写到result里面，然后，后面一个还是字母的话，说明就应该是a1了，于是进入else
            //  把1写进去，然后再跳到下面把a写进去！
            result[slow--] = array[fast--];
        }
        return new String(result);
    }

    private int copyDigit(char[] array, int index, int count) {
        //  Assume array is large enough, so index 不会OOB！！
        int length = 0;
        for (int i = count; i > 0; i /= 10) {
            index++;
            length++;
        }
        for (int i = count; i > 0; i /= 10) {
            array[--index] = (char) ('0' + i % 10);
        }
        return length;
    }

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        sb1.append('a');
        StringBuilder sb2 = new StringBuilder();
        sb2.append("bc");
        sb2.reverse();
        System.out.println(sb1.append(sb2));

    }
}
