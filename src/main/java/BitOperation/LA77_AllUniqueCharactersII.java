package BitOperation;

public class LA77_AllUniqueCharactersII {
    public boolean allUnique(String word) {
        int[] unique = new int[8];  //  each int value can represent 32 bits
        //  so we need 8 ints to represent 256 bits (for any ASCII character)
        char[] array = word.toCharArray();
        for (char c : array) {  // 比如c的ascii code = 120，那么对应的120/32 = 3, 第三组，120 % 32 = 24,
            // 那么第24位应该设为1，表示出现过了
            if ((unique[c / 32] >>> (c % 32) & 1) == 1) {
                return false;
            }
            unique[c / 32] |= 1 << (c % 32);    // 要把c对应所在的那一组对应的位置标1
        }
        return true;
    }
}
