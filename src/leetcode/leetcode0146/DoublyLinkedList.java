package leetcode.leetcode0146;

public class DoublyLinkedList {
    public int size;
    private Node head;
    private Node tail;
    public DoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public void insertFromHead(Node node) {
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void moveToHead(Node node) {
        if (node.key == head.key) {
            return;
        }

        if (node.key == tail.key) {
            tail = tail.prev;
            tail.next = null;
            node.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        insertFromHead(node);
        size--;
    }


    public Node removeLast() {
        if (size == 0) {
            return null;
        }
        Node res = tail;
        if (size == 1) {
            tail = null;
            head = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            res.prev = null;
        }
        size--;
        return res;
    }
}
