package leetcode.leetcode0208;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private class Node {
        Map<Character, Node> nodes;
        boolean isWord;
        Node() {
            nodes = new HashMap<>();
            isWord = false;
        }
    }
    private Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            Character c = word.charAt(i);
            if (!cur.nodes.containsKey(c)) {
                cur.nodes.put(c, new Node());
            }
            cur = cur.nodes.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Node cur = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            Character c = word.charAt(i);
            if (!cur.nodes.containsKey(c)) {
                return false;
            }
            cur = cur.nodes.get(c);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            Character c = prefix.charAt(i);
            if (!cur.nodes.containsKey(c)) {
                return false;
            }
            cur = cur.nodes.get(c);
        }
        return true;
    }
}
