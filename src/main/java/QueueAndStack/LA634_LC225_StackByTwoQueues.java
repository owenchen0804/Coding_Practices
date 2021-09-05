public class LA634_LC225_StackByTwoQueues {
    public LA634_LC225_StackByTwoQueues() {}

    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    public void push(int x) {
        q1.offer(x);
    }

    public Integer pop() {
        // 以下情况是可以调用.size()的情况，如果不知道的话需要用prev/curr

//        if (q1.isEmpty()) {
//            return null;
//        }
//        while (q1.size() > 1) {
//            q2.offer(q1.poll());
//        }
//        int result = q1.poll();
//        Queue<Integer> temp = q2;
//        q2 = q1;
//        q1 = temp;
//        return result;

        //  连续poll两次，哪怕都是null也没关系，返回值就是null
        Integer prev = q1.poll();
        Integer curr = q1.poll();
        while (curr != null) {
            q2.offer(prev);
            prev = curr;
            curr = q1.poll();
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return prev;
    }

    public Integer top() {
        //  下面的方法不适用于queue所拥有的methods
//        if (q1.isEmpty()) {
//            return null;
//        }
//        while (q1.size() > 0) {
//            q2.offer(q1.poll());
//        }
//        int result = q2.peek();
//        Deque<Integer> temp = q2;
//        q2 = q1;
//        q1 = temp;
//        return result;
        Integer result = pop();
        if (result != null) {
            q1.offer(result);
        }
        return result;
    }

    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}