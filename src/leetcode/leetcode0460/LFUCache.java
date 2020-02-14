package leetcode0460;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

    private Node head;
    private int capacity;
    private HashMap<Integer, Integer> valueHash;
    private HashMap<Integer, Node> nodeHash;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        valueHash = new HashMap<>();
        nodeHash = new HashMap<>();
    }

    public int get(int key) {
        if (valueHash.containsKey(key)) {

        }
        return -1;
    }

    private void visit(int key) {
        Node node = nodeHash.get(key);
        node.keys.remove(key);
    }

}
