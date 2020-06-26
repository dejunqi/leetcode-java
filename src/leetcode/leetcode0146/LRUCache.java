package leetcode.leetcode0146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Node> cache;
    int capacity;
    DoublyLinkedList list;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        list = new DoublyLinkedList();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            list.moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            Node node = new Node(key, value);
            cache.put(key, node);
            list.insertFromHead(node);
        } else {
            Node node = cache.get(key);
            node.val = value;
            list.moveToHead(node);
        }

        if (cache.size() > this.capacity) {
            Node node = list.removeLast();
            cache.remove(node.key);
        }

    }

}
