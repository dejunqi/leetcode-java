package leetcode0460;

import java.util.LinkedHashSet;

public class Node {
    int count = 0;
    LinkedHashSet<Integer> keys;
    Node prev;
    Node next;

    Node(int count) {
        this.count = count;
        keys = new LinkedHashSet<>();
        prev = next = null;
    }
}