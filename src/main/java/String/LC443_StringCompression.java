package String;

public class LC443_StringCompression {
    public int compress(char[] chars) {
        int resultIndex = 0, index = 0;
        //  int count = 0;
        while (index < chars.length) {
            char c = chars[index];
            int count = 0;  //  每次遇到不同的c，那么count要reset to 0
            while (index < chars.length && chars[index] == c) {
                //  统计同样的字母出现的次数，只有超过1次才需要占用一个位置来表示次数
                //  如果正好就是1次的话那么不需要占用resultIndex的位置
                index++;
                count++;
            }
            //  先把这个重复or没重复的字符给算上
            chars[resultIndex++] = c;
            if (count != 1) {
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[resultIndex++] = digit;
                }
            }
        }
        return resultIndex;
        //  自始至终我是overwrite到chars[]中，所以没有开辟额外的space
    }
}
