package googleInterview.deleteNodeinNTree;

import java.util.*;



public class Solution {

    private class Node {
        int val;
        String color;
        Set<Node> children;
        Node(String c, int v) {
            val = v;
            color = c;
            children = new HashSet<>();
        }
    }

    private class Pair {
        Node parent;
        Node node;
        Pair(Node p, Node n) {
            parent = p;
            node = n;
        }
    }

    // 0 for blue and 1 for red;
    public List<Node> deleteRed(Node root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(null, root));
        List<Node> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            Node parent = cur.parent, node = cur.node;

            for (Node n : node.children) {
                queue.add(new Pair(node, n));
            }

            if (node.color.equals("RED")) {
                parent.children.remove(node);
            }

            if (parent != null && parent.color.equals("RED") && node.color.equals("BLUE")) {
                res.add(node);
            }
        }

        if (root.color.equals("BLUE")) {
            res.add(0, root);
        }

        return res;

    }

    private void inorderTraverse(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.color + ": " + root.val);
        for (Node n : root.children) {
            inorderTraverse(n);
        }
    }


    public void test() {
        String BLUE = "BLUE", RED = "RED";
        Node n1 = new Node(BLUE, 1);
        Node n2 = new Node(BLUE, 2);
        Node n3 = new Node(RED, 3);
        Node n4 = new Node(BLUE, 4);
        Node n5 = new Node(RED, 5);
        Node n6 = new Node(RED, 6);
        Node n7 = new Node(BLUE, 7);
        Node n8 = new Node(BLUE, 8);
        Node n9 = new Node(BLUE, 9);
        Node n10 = new Node(BLUE, 10);
        Node n11 = new Node(BLUE, 11);
        Node n12 = new Node(BLUE, 12);
        Node n13 = new Node(BLUE, 13);

        n1.children = new HashSet<>(Arrays.asList(n2, n3, n4, n5));
        n3.children = new HashSet<>(Arrays.asList(n6, n7, n8));
        n6.children = new HashSet<>(Arrays.asList(n9, n10, n11));
        n10.children = new HashSet<>(Arrays.asList(n12, n13));

        System.out.println("Traverse the tree:");
//        inorderTraverse(n1);


        List<Node> res = deleteRed(n1);
        for (Node n : res) {
            System.out.println(n.val + ": " + n.color);
        }

        inorderTraverse(n1);
    }
}
