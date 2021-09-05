public class LA280_SortWithTwoStacks {
    public void sort(Deque<Integer> s1) {
        if (s1 == null || s1.size() <= 1) {
            return;
        }
        Deque<Integer> s2 = new ArrayDeque<>();
        sort(s1, s2);
    }

    private void sort(Deque<Integer> s1, Deque<Integer> s2) {
        //  注意最外层的while，只要s1里面还有值，就说明有数字没有get sorted，就要继续执行
        while (!s1.isEmpty()) {
            int globalMin = Integer.MAX_VALUE;
            int count = 0;
            while (!s1.isEmpty()) {
                //  这里也可以是int temp = s1.pollFirst() 一回事
                if (s1.peekFirst() < globalMin) {
                    globalMin = s1.peekFirst();
                    count = 1;
                } else if (s1.peekFirst() == globalMin) {
                    count++;
                }
                s2.offerFirst(s1.pollFirst());
            }
            while (!s2.isEmpty() && s2.peekFirst() >= globalMin) {
                int temp = s2.pollFirst();
                if (temp != globalMin) {
                    s1.offerFirst(temp);
                }
            }
            while (count > 0) {
                s2.offerFirst(globalMin);
                count--;
            }
        }
        while (!s2.isEmpty()) {
            s1.offerFirst(s2.pollFirst());
        }
    }
}