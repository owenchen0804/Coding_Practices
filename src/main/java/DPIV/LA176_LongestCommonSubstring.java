package DPIV;

public class LA176_LongestCommonSubstring {
    public String longestCommon(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        int longest = 0;
        int start = 0; // 这是因为需要返回具体哪个最长的substring
        int[][] common = new int[sa.length][ta.length];
        for (int i = 0; i < sa.length; i++) {
            for (int j = 0; j < ta.length; j++) {
                //  只有当前的character一样的时候，才会讨论，其它情况一律为0，
                //  所以不用额外写语句，common[][]其他地方都是0
                //  同时要考虑边界问题，i或者j为0的时候i-1 or j-1是负数
                if (sa[i] == ta[j]) {
                    if (i == 0 || j == 0) {
                        common[i][j] = 1;
                    }
                    else {
                        common[i][j] = common[i - 1][j - 1] + 1;
                    }
                    if (common[i][j] > longest) {
                        //  发现有新的longest要update
                        //  同时要往回走找到新longest的起点
                        longest = common[i][j];
                        start = i - longest + 1;
                    }
                }
            }
        }
        return s.substring(start, start + longest);
    }
}
