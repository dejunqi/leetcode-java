package utils.practice;

import java.util.*;
import utils.TreeNode;

public class Solution {
    public void deleteInvalidEdge(TreeNode root) {
        root = helper(root, null, null);
    }

    private TreeNode helper(TreeNode node, TreeNode leftParent, TreeNode rightParent) {
        if (node == null) {
            return null;
        }

        if (leftParent != null && node.val <= leftParent.val
                || rightParent != null && node.val >= rightParent.val) {
            return null;
        }

        node.left = helper(node.left, null, node);
        node.right = helper(node.right, node, null);
        return node;
    }
}
