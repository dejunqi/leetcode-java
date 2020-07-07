package leetcode.leetcode0432;

import java.util.*;

public class AllOne {

    private Node head;
    private Node tail;
    Map<String, Node> map;
    int size;

    /** Initialize your data structure here. */
    public AllOne() {
        head = null;
        tail = null;
        map = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            int freq = node.freq;
            node.keys.remove(key);
            if (node.next == null) {
                Node newNode = new Node(freq + 1);
                node.next = newNode;
                newNode.prev = node;
                newNode.keys.add(key);
                map.put(key, newNode);
                tail = newNode;
            } else {
                Node next = node.next;
                if (next.freq - freq > 1) {
                    Node newNode = new Node(freq + 1);
                    newNode.keys.add(key);
                    node.next = newNode;
                    newNode.prev = node;
                    newNode.next = next;
                    newNode.prev = newNode;
                    map.put(key, newNode);
                } else {
                    next.keys.add(key);
                    map.put(key, next);
                }
            }

            if (node.keys.size() == 0) {

            }

        } else { // map does not contains the key
            if (head == null) {
                head = new Node(1);
                head.keys.add(key);
                tail = head;
            } else {
                head.keys.add(key);
            }
            map.put(key, head);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {

    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return "";
    }

    public void visualize() {
        System.out.println("Map");
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key).toString());
        }

        System.out.println("\nList");
        Node cur = head;
        while (cur != null) {
            String arr = " -> ";
            String res = cur.toString() + (cur.next != null ? arr : "");
            System.out.print(res);
            cur = cur.next;
        }
        System.out.println("\n");
    }

}


