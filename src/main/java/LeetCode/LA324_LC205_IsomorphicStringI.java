package LeetCode;

public class LA324_LC205_IsomorphicStringI {
    public boolean isIsomorphic(String s, String t) {
        // 因为是characters可以考虑用int[256]而不用HashMap
        // 思路是:字符被map成另一个字符的时候所在的index位置不能变，那么可以用每个char第一次出现时所在的坐标表示
        // 比如egg -> e首次出现在index = 0 可以表示为1 (0 + 1 = 1)，g首次出现是在index = 1上可以表示为2 (1 + 1 = 2)
        // 那么add -> 同理，a可以为1，d可以为2，这样OK的，实际上是记录first occurrence
        // 把每次第一个出现的字符的位置对应到m[]里面定为index + 1
        // 为什么+1：因为m[] new出来默认值是0，那么string里面index = 0的那个字符出现了它对应的值至少应该是1，而不是0
        // 如果是0的话就和默认值一样了，不知道到底是这个character从来没出现过，还是已经在第一个字符出现
        if (s.length() == 1) return true;
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)] = m2[t.charAt(i)] = i + 1;
            // m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
