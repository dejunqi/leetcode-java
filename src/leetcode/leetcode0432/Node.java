package leetcode.leetcode0432;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Node {
    int freq;
    Node prev;
    Node next;
    Set<String> keys;

    public Node(int freq) {
        this.freq = freq;
        keys = new HashSet<>();
    }

    public String toString() {
        String[] arr = new String[keys.size()];
        keys.toArray(arr);
        return "( " + freq + ": " + Arrays.toString(arr) + " )";
    }
}
