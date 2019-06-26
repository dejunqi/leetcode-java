package advancedDataStructure.nWayTree;
import java.util.List;
import java.util.ArrayList;

public class Node {
    int val;
    List<Node> children;
    Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}
