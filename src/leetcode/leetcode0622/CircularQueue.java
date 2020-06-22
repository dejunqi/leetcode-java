package leetcode0622;

class CircularQueue {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;
    private int capacity ;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public CircularQueue(int k) {
        head = tail = null;
        size = 0;
        capacity = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (capacity == size) {
            return false;
        }
        ListNode node = new ListNode(value);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (size == 0) {
            return false;
        } else if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (size == 0) {
            return -1;
        }
        return head.val;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (size == 0) {
            return -1;
        }
        return tail.val;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */