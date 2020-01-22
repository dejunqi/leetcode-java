package utils.practice;

import java.util.*;

public class FileTree {
    private class Node {
        String dir;
        List<Node> childrens;
        boolean isFile;
        Node(String d) {
            dir = d;
            childrens = new ArrayList<>();
            if (d.contains(".")) {
                isFile = true;
            }
        }
    }

    private Node root;

    public FileTree() {
        root = new Node("");
    }

    public void insert(String path) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(path.split("/")));
        // "/a/b/file.txt"
        // ["a", "b", "file.txt"]
        insertHelper(root, queue);
    }

    private void insertHelper(Node node, Queue<String> queue) {
        if (node.childrens.size() == 0) {
            if (queue.size() != 1) { // means directory does not exist
                return;
            }
            node.childrens.add(new Node(queue.poll()));
        }

        String d = queue.poll();
        for (Node n : node.childrens) {
            if (n.dir.equals(d)) {
                insertHelper(n, queue);
            }
        }
    }
}
