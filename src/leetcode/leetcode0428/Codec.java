package leetcode0428;

import java.util.*;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return "";
        List<String> res = new ArrayList<>();
        serializeHelper(res, root);
        return String.join(",", res);
    }

    private void serializeHelper(List<String> res, Node node) {
        int len = node.children.size();
        res.add(Integer.toString(node.val));
        res.add(Integer.toString(len));

        if (len > 0) {
            for (Node v : node.children) {
                serializeHelper(res, v);
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0) return null;
        String[] vals = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(vals));
        return deserializeHelper(queue);
    }

    private Node deserializeHelper(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }

        Node root = new Node(-1, new ArrayList<>());
        int val = Integer.parseInt(queue.poll());
        int childrenSize = Integer.parseInt(Objects.requireNonNull(queue.poll()));
        root.val = val;
        for (int i = 0; i < childrenSize; i++) {
            root.children.add(deserializeHelper(queue));
        }
        return root;
    }
}
