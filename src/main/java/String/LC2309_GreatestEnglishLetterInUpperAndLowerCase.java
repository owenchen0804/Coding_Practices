package String;

public class LC2309_GreatestEnglishLetterInUpperAndLowerCase {
    public String greatestLetter(String s) {
        char[] small = new char[26];
        char[] large = new char[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                small[c - 'a']++;
            }
            else if (c >= 'A' && c <= 'Z') {
                large[c - 'A']++;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (large[i] > 0 && small[i] > 0) {
                char c = (char) (i + 'A');
                return Character.toString(c);
            }
        }
        return "";
    }
}
