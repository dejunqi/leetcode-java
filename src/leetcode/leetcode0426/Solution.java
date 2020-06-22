package leetcode0426;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> nodes = new ArrayList<>();
        helper(nodes, root);
        nodes.get(0).left = nodes.get(nodes.size() - 1);
        nodes.get(nodes.size() - 1).right = nodes.get(0);
        return nodes.get(0);
    }

    private void helper(List<Node> nodes, Node node) {
        if (node == null) {
            return;
        }
        helper(nodes, node.left);
        if (nodes.size() > 0) {
            Node prevNode = nodes.get(nodes.size() - 1);
            prevNode.right = node;
            node.left = prevNode;
        }
        nodes.add(node);
        helper(nodes, node.right);
    }
}
