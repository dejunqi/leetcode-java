package leetcode0428;

import java.util.ArrayList;
import java.util.List;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        serializeHelper(null, root, res);
        return res.toString();
    }


    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        return null;
    }


    private void serializeHelper(Node parent, Node cur, StringBuilder res) {
        List<Node> children = cur.children;
        if (parent == null) {
            res.append(cur.val + ":" + "#");
        } else {
            res.append(cur.val + ":" + parent.val);
        }
        res.append(",");
        if (children.size() == 0) {
            return;
        }
        for (Node n : children) {
            serializeHelper(cur, n, res);
        }
    }
}
