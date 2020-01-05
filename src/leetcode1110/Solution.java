package leetcode1110;

import utils.TreeNode;

import java.util.*;


public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        TreeNode dummy = new TreeNode(Integer.MIN_VALUE);
        Set<Integer> toDelete = new HashSet<>();
        for (int v : to_delete) {
            toDelete.add(v);
        }
        toDelete.add(Integer.MIN_VALUE);
        dummy.left = root;
        helper(dummy, res, toDelete);
        return res;
    }

    private TreeNode helper(TreeNode node, List<TreeNode> res, Set<Integer> toDelete ) {
        if (node == null) {
            return null;
        }
        TreeNode left = helper(node.left, res, toDelete);
        TreeNode right = helper(node.right, res, toDelete);
        if (toDelete.contains(node.val)) {
            if (left != null) {
                res.add(left);
            }
            if (right != null) {
                res.add(right);
            }
            return null;
        }

        node.left = left;
        node.right = right;
        return node;
    }
}
