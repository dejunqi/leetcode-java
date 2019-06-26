package advancedDataStructure.nWayTree;

import java.util.List;

public class DeleteEntry {
    boolean shouldDelete;
    List<Node> children;
    public DeleteEntry(boolean shouldDelete, List<Node> children) {
        this.shouldDelete = shouldDelete;
        this.children = children;
    }
}
