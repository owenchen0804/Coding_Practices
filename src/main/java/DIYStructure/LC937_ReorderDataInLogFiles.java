package DIYStructure;

import java.util.Arrays;
import java.util.Comparator;

public class LC937_ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        //  这题主要就是写一个comparator，来定义所有的logs
        //  注意里面的条件：
        //  letter放在digit前面
        //  如果2个logs都是digit，那么相对顺序不用变
        //  letter如果内容相同，还要看identifier的顺序
        Comparator<String> myComparator = new Comparator<String>() {
            //  右边的<>里面要写String，不然的话会报错，可能不一定和左边的type align会有问题！

            @Override
            public int compare(String s1, String s2) {
                int s1SpaceIndex = s1.indexOf(' ');
                int s2SpaceIndex = s2.indexOf(' ');
                char s1FirstChar = s1.charAt(s1SpaceIndex + 1);
                char s2FirstChar = s2.charAt(s2SpaceIndex + 1);

                //  注意在ASCII🐴里面先数字，后大写，再小写
                if (s1FirstChar <= '9') {
                    if (s2FirstChar <= '9') {
                        return 0;
                    }
                    //  如果s1是数字，s2是letter，那么s2更优先
                    return 1;
                }
                else if (s2FirstChar <= '9') {
                    //  如果s1是字母，s2是数字，那么s1更优先
                    return -1;
                }
                else {
                    //  走到这里说明s1, s2都是letter log，那么再比较
                    int preCompare = s1.substring(s1SpaceIndex + 1).compareTo(s2.substring(s2SpaceIndex + 1));
                    //  如果没分出胜负说明letter内容一致，再比较identifier
                    if (preCompare == 0) {
                        return s1.substring(0, s1SpaceIndex).compareTo(s2.substring(0, s2SpaceIndex));
                    }
                    return preCompare;
                }
            }
        };

        Arrays.sort(logs, myComparator);
        return logs;
    }
}
