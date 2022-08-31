package DFS;

public class CanChain {
    public boolean canChain(String[] names) {
        //  从index = 1开始，每次swap后面的string到当前的index，看看能否和
        //  names[index - 1]能否connect，如果有，那么就继续往后看
        //  如果每一个都和前面不能connect那么只能返回false
        return DFS(names, 1);
    }

    private boolean DFS(String[] names, int index) {
        // base case
        if (index == names.length) {
            return canConnect(names[index - 1], names[0]);
        }
        for (int i = index; i < names.length; i++) {
            //  先把每一个(包括当前index)的string都swap过来，然后看是否connect
            //  如果能connect了再往下一步走
            swap(names, index, i);
            if (canConnect(names[index - 1], names[index])) {
                return DFS(names, index + 1);
            }
            swap(names, index, i);
        }
        return false;
    }

    private boolean canConnect(String s1, String s2) {
        return s1.charAt(s1.length() - 1) == s2.charAt(0);
    }

    private void swap(String[] s, int i, int j) {
        String temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        String[] s = {"ALICE", "CHARLES", "ERIC", "SOPHIA"};
        CanChain test = new CanChain();
        test.canChain(s);
    }
}
