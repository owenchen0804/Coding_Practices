package Contest;

public class Test2 {
    public int divisorSubstrings(int num, int k) {
        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i < k) {
                sb.append(s.charAt(i));
            }
            else {
                int cand = Integer.parseInt(sb.toString());
                if (cand == 0) {
                    continue;
                }
                if (num % cand == 0) {
                    count++;
                }
                if (i < s.length()) {
                    sb.append(s.charAt(i));
                    sb.deleteCharAt(0);
                }
            }

        }
        return count;
    }


    public static void main(String[] args) {
        char[] tmp = new char[26];
        System.out.print(tmp[0]);
       // System.out.print(tmp[2] - 1);

    }
}
