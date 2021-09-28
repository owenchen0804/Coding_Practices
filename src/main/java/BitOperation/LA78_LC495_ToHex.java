package BitOperation;

public class LA78_LC495_ToHex {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int temp = num & 0xf;
            if (temp <= 9) {
                sb.append((char)('0' + temp));
            }
            else {
                sb.append((char)('a' + temp - 10));
            }
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}
