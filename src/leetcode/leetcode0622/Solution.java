package leetcode0622;

public class Solution {
    public void test() {
        CircularQueue queue = new CircularQueue(8);
        queue.enQueue(3);
        queue.enQueue(9);
        queue.enQueue(5);
        queue.enQueue(0);
        queue.deQueue();
        queue.deQueue();
        queue.isEmpty();
        queue.isEmpty();
        System.out.println(queue.Rear());
        System.out.println(queue.Rear());
        queue.deQueue();

    }
}
