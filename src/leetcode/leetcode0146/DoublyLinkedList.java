package leetcode0146;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertHead(Node node) {
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

    public void visit(Node node) {
        if (node.key == head.key) {
            return;
        }
        if (node.key == tail.key) {
            tail = tail.prev;
            tail.next = null;
            node.prev = null;
            insertHead(node);
        } else {
            Node prev = node.prev;
            Node post = node.next;
            prev.next = post;
            post.prev = prev;
            insertHead(node);
        }
        // we invoked insertHead which increase the size
        size--;
    }

    public Node removeLast() {
        Node res = tail;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            res.prev = null;
        }
        size--;
        return res;
    }

    public int size() {
        return this.size;
    }

}
