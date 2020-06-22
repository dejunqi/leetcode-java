package googleInterview.randomMaze;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class RandomQueue {
    Deque<int[]> queue;
    Random random;
    RandomQueue() {
        queue = new LinkedList<>();
        random = new Random();
    }

    public void add(int[] point) {
        double num = Math.random();
        if (num < 0.5) {
            queue.addFirst(point);
        } else {
            queue.addLast(point);
        }
    };

    public int[] pop() {
        int num = random.nextInt(11);
        if (num % 2 == 0) {
            return queue.pollLast();
        } else {
            return queue.pollFirst();
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
