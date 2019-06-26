package advancedDataStructure.nWayTree;

import java.util.ArrayList;
import java.util.List;

public class Tree {


    private Node root;

    public Tree() {
        root = null;
    }

    public Tree(int rootKey) {
        root = new Node(rootKey);
    }

    public void insert(int key, int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        insetHelper(key, val, root);
    }

    public void delete(int key) {
        deleteHelper(key, root);
    }

    private DeleteEntry deleteHelper(int key, Node node) {
        if (node.children.size() == 0) {
            new DeleteEntry(false, null);
        }

        if (key == node.val) {
            return new DeleteEntry(true, node.children);
        }

        List<Node> children = node.children;
        for (Node n : children) {
            DeleteEntry res = deleteHelper(key, n);
            if (res.shouldDelete) {
                children.remove(n);
                mergeList(children, res.children);
                break;
            }
        }
        return new DeleteEntry(false, null);
    }

    private void mergeList(List<Node> listA, List<Node> listB) {

    }


    private void insetHelper(int key, int val, Node node) {
        if (node.val == key) {
            node.children.add(new Node(val));
            return;
        }

        List<Node> children = node.children;
        if (children.size() == 0) return;
        for (Node n : children) {
            insetHelper(key, val, n);
        }
    }

}
