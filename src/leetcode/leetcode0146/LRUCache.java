package leetcode0146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    DoublyLinkedList list;
    Map<Integer, Node> cache;
    int capacity;

    public LRUCache(int capacity) {
        list = new DoublyLinkedList();
        cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            list.visit(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node;
        if (cache.containsKey(key)) {
            node = cache.get(key);
            node.val = value;
            list.visit(node);
        } else {
            node = new Node(key, value);
            list.insertHead(node);
            cache.put(key, node);
            if (list.size() > capacity) {
                Node tail = list.removeLast();
                cache.remove(tail.key);
            }
        }
    }

}
