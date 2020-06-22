package leetcode0116;

public class Solution {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        Node cur = root;
        Node dummy = new Node(-1);
        Node p = dummy;

        while (cur != null) {
            if (cur.left != null) {
                p.next = cur.left;
                p = p.next;
            }
            if (cur.right != null) {
                p.next = cur.right;
                p = p.next;
            }
            if (cur.next != null) {
                cur = cur.next;
            } else {
                cur = dummy.next;
                dummy.next = null;
                p = dummy;
            }
        }
        return root;
    }

    public void test() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        Node root = connect(n1);
    }

}
