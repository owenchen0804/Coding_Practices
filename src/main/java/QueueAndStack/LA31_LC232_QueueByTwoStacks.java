package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LA31_LC232_QueueByTwoStacks {
    public LA31_LC232_QueueByTwoStacks() {
    }

    Deque<Integer> s1 = new ArrayDeque<>();
    Deque<Integer> s2 = new ArrayDeque<>();

    private void shuffleIfNecessary() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.offerFirst(s1.pollFirst());
            }
        }
    }

    public Integer poll() {
        shuffleIfNecessary();
        if (s2.isEmpty()) {
            return null;
        }
        return s2.pollFirst();
    }

    public void offer(int element) {
        s1.offerFirst(element);
    }

    public Integer peek() {
        shuffleIfNecessary();
        if (s2.isEmpty()) {
            return null;
        }
        return s2.peekFirst();
    }

    public int size() {
        return s1.size() + s2.size();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

}