package DFS_II;

import java.util.ArrayList;
import java.util.List;

public class LA147_LC93_RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        // 因为要对input一个个char的分析，所以转成charArray比较方便
        DFS(s.toCharArray(), 0, 0, sb, result);
        return result;
    }

    private void DFS(char[] ip, int level, int offset, StringBuilder sb, List<String> result) {
        if (level == 4) {
            if (sb.length() == ip.length + 4) {
                //  这里要注意，可能level到4了，打了4个点，但是ip所有的数字没有都用完，那也不符合要求
                result.add(sb.substring(0, sb.length() - 1));
                //  因为最后是follow前面3个level都会加上"."，在加到result之前要去掉第4段的“.”
            }
            return;
        }

        if (offset < ip.length) {
            //  offset到ip[]这个全是数字的array的最后一位数字也是符合条件的，
            //  把最后一位当成level4，然后加上"."
            //  offset始终跟着input的长度，而不是sb的长度
            sb.append(ip[offset]).append('.');
            DFS(ip, level + 1, offset + 1, sb, result);
            // 当前只append了ip[]里面的一位，所以offset只+1，不包括'.'
            sb.delete(sb.length() - 2, sb.length());
            // delete()里面第一个inclusive，第二个exclusive
        }

        if (offset + 1 < ip.length) { // 到最后还可以放2位数作为一个level
            char a = ip[offset];
            char b = ip[offset + 1];
            if (a != '0') {
                sb.append(a).append(b).append('.');
                DFS(ip, level + 1, offset + 2, sb, result);
                sb.delete(sb.length() - 3, sb.length());
            }
        }

        if (offset + 2 < ip.length) {
            char a = ip[offset];
            char b = ip[offset + 1];
            char c = ip[offset + 2];
            if ((a == '1' ) || (a == '2' && b >= '0' && b <= '4') ||
                    (a == '2' && b == '5' && c >= '0' && c <= '5')) {
                sb.append(a).append(b).append(c).append('.');
                DFS(ip, level + 1, offset + 3, sb, result);
                sb.delete(sb.length() - 4, sb.length());
            }
        }
    }
}
