public class LA645_DequeByThreeStacks {
    private Deque<Integer> s1;
    private Deque<Integer> s2;
    private Deque<Integer> s3;

    public LA645_DequeByThreeStacks() {
        s1 = new ArrayDeque<Integer>();
        s2 = new ArrayDeque<Integer>();
        s3 = new ArrayDeque<Integer>();
    }

    public void offerFirst(int element) {
        s1.offerFirst(element);
    }

    public void offerLast(int element) {
        s2.offerFirst(element);
    }

    private void move(Deque<Integer> src, Deque<Integer> dest) {
        if (!dest.isEmpty()) {
            return;
        }
        int halfSize = src.size() / 2;
        for (int i = 0; i < halfSize; i++) {
            s3.offerFirst(src.pollFirst());
        }
        while (!src.isEmpty()) {
            dest.offerFirst(src.pollFirst());
        }
        while (!s3.isEmpty()) {
            src.offerFirst(s3.pollFirst());
        }
    }

    public Integer pollFirst() {
        //  以下重复代码，都适用于pollFirst/pollLast/peekFirst/peekLast 可以抽象出来成helper method
//        if (s1.isEmpty()) {
//            int size = s2.size();
//            for (int i = 0; i < size/2; i++) {
//                s3.offerFirst(s2.pollFirst());
//            }
//            while (!s2.isEmpty()) {
//                s1.offerFirst(s2.pollFirst());
//            }
//            while (!s3.isEmpty()) {
//                s2.offerFirst(s3.pollFirst());
//            }
//        }
        move(s2, s1);
        return s1.isEmpty() ? null : s1.pollFirst();
    }

    public Integer pollLast() {
        move(s1, s2);
        return s2.isEmpty() ? null : s2.pollFirst();
    }

    public Integer peekFirst() {
        move(s2, s1);
        return s1.isEmpty() ? null : s1.peekFirst();
    }

    public Integer peekLast() {
        move(s1, s2);
        return s2.isEmpty() ? null : s2.peekFirst();
    }

    public int size() {
        return s1.size() + s2.size();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}