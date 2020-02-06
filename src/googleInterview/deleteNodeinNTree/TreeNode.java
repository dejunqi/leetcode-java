package googleInterview.deleteNodeinNTree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    String color;
    int id;
    List<TreeNode> children;
    public TreeNode(String color, int id) {
        this.color = color;
        this.id = id;
        children = new ArrayList<>();
    }
}
