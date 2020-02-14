package leetcode0133;


import java.util.*;

public class Solution {

    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    public Node cloneGraph(Node node) {

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        Set<Node> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            List<Node> neighbors = cur.neighbors;
            if (neighbors.size() > 0) {
                for (Node v : neighbors) {
                    if (!visited.contains(v)) {
                        map.put(v, new Node(v.val, new ArrayList<>()));
                        queue.offer(v);
                        visited.add(v);
                    }
                }
            }
        }

        for (Node u : map.keySet()) {
            List<Node> neighbors = u.neighbors;
            Node clone = map.get(u);
            for (Node v : neighbors) {
                clone.neighbors.add(map.get(v));
            }
        }

        return map.get(node);
    }
}
