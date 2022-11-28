package String;

public class LC767_ReorganizeString {
    public String reorganizeString(String s) {
        //  注意如果最多的那个letter超过了一半，那么肯定没法做到adjacent not same了
        //  所以在统计的时候做一个判断，另外由于s只会是lower case letter，所以不需要map
        //  只用一个大小为26的数组就可以
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        //  统计哪个字母出现的次数最多
        int max = 0, letter = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > max) {
                max = map[i];
                letter = i;
            }
        }
        //  如果max超过了s总长度的一半，那么肯定实现不了，返回空
        if (max > (s.length() + 1) / 2) {
            return "";
        }
        //  从index = 0 开始，每隔一个放置最多的那个letter
        //  如果放完了，就可以开始放其他的letter，也是隔一个放一个
        //  如果到了最后还没有放完，那么就要回到index = 1这里，因为这里肯定还是空的，也是继续隔一个放
        int index = 0;
        char[] result = new char[s.length()];
        while (map[letter] > 0) {
            result[index] = (char) ('a' + letter);
            index += 2;
            map[letter]--;
        }
        //  走到这里说明最多freq的那个letter已经放完了，就要隔一个放其他的letter，直到最后，再
        //  跳回到最前面index = 1
        for (int i = 0; i < map.length; i++) {
            while (map[i] > 0) {
                //  所有map[i]不为0的letter都要填进去
                //  先考虑到底了没有，如果到底就要回头到index = 1

                //  注意这里哦，只会有1次回头，因为剩下的坑就是走到尾巴后掉头到index = 1
                //  那么剩下的位置肯定是足够剩下的字母分了，因为总长度是确定的
                if (index >= s.length()) {
                    //  回头
                    index = 1;
                }
                //  不管回头了没有，都是一样的每隔1个放置letter的操作
                result[index] = (char) ('a' + i);
                index += 2;
                map[i]--;
            }
        }
        //  return result.toString();
        return String.valueOf(result);
    }
}
