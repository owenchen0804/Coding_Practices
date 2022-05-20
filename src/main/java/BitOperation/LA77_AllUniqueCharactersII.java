package BitOperation;

//Analysis：
//
//        共256 characters， 每个只有出现和没出现两种情况，所以可以用0/1表示这两种状态，
//        则一共需要256个位置来存每个char的状态信息。
//        考虑到int在java里是32bits， 256/32=8， 所以可以用长度为8的int[] array来记录。
//        int [] array 的物理意义就是长度为8，共256个bits表示256个chars的状态信息。
//        对 string 里每一个 character，char c = string.charAt(i),
//        这一句对jvm来说已经是以ascii value 的形式存在了，所以直接用 c / 32， c % 32 得到
//        就是c应该在array的哪一个元素的哪一个bit位。
//        case1：想知道c有没有出现过，就看 c/ 32, c%32这一位是不是1，回归到bitwise怎么看某一位是不是1，
//        就是让这一位移动到最右边，再&1， array[c / 32] >> (c % 32) & 1 ==1 ,
//        如果是，则说明非首次出现，return false。
//        否则， 是首次出现，则需要将 c / 32, c % 32位置由default 0 set 成 1, 涉及到bitwise如何对某位置1的运算，
//        则让1左移到该位，然后或运算， 即  array[c / 32] |= (1 << (c % 32).


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
