package Contest;

public class LC2269_FindTheKBeautyOfANumber {
    public int divisorSubstrings(int num, int k) {
        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //  长度不够k，所以只需要先append
            if (i < k) {
                sb.append(s.charAt(i));
            }
            else {
                //  长度够k了开始看是否当前的sb满足条件
                //  但是要注意，这里sb append的是从[0, k- 1]，但是！现在的i到了k
                int cand = Integer.parseInt(sb.toString());
                if (cand != 0 && num % cand == 0) {
                    count++;
                }
                //  只有同时满足上面条件才会count++，其他的话都是正常的append + delete
                sb.append(s.charAt(i));
                sb.deleteCharAt(0);
            }
        }
        //  走到这里正好是sb append了最后k个，同时i也到了nums.length，但是不需要care
        int last = Integer.parseInt(sb.toString());
        if (last != 0 && num % last == 0) {
            count++;
        }
        return count;
    }
}
