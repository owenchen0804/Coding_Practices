package LeetCode;

public class LC165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int index1 = 0, index2 = 0;
        while (index1 < version1.length() || index2 < version2.length()) {
            int ver1 = 0, ver2 = 0;
            // 算出version1的'.'出现之前的数字
            while (index1 < version1.length() && version1.charAt(index1) != '.') {
                ver1 = ver1 * 10 + version1.charAt(index1) - '0';
                index1++;
            }
            while (index2 < version2.length() && version2.charAt(index2) != '.') {
                ver2 = ver2 * 10 + version2.charAt(index2) - '0';
                index2++;
            }
            if (ver1 < ver2) return -1;
            if (ver1 > ver2) return 1;
            index1++;
            index2++;
        }
        return 0;
    }
}
