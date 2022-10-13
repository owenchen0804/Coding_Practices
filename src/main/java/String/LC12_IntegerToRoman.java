package String;

public class LC12_IntegerToRoman {
    public String intToRoman(int num) {
        //  用values写出所有不同的strs组合对应的所有的值，从大到小排列，必然是先满足最大的，不够大了才往右继续走
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        //  把所有可能出现的字母排列都列出来，其他的数字只是对它们的次数的增加/重复，这样就可以继续操作
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
            i++;
        }
        return sb.toString();
    }
}
