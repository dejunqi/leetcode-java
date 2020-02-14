package utils.practice;


import java.util.Deque;
import java.util.LinkedList;

public class RandomQueue  {

    Deque<int[]> queue;
    RandomQueue() {
        queue = new LinkedList<>();
    }

    public void add(int[] point) {
        if (Math.random() > 0.5) {
            queue.addLast(point);
        } else {
            queue.addFirst(point);
        }
    }

    public int[] poll() {
        if (Math.random() > 0.5) {
            return queue.pollFirst();
        } else {
            return queue.pollLast();
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
