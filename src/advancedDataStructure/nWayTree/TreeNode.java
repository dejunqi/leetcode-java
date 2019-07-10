package advancedDataStructure.nWayTree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public List<TreeNode> children;
    public TreeNode(int v) {
        val = v;
        children = new ArrayList<>();
    }
}
