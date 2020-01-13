package utils.practice;


import java.util.*;


import utils.TreeNode;

public class Solution {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> todelete = new HashSet<>();
        for (int v : to_delete) {
            todelete.add(v);
        }
        int MAX = Integer.MAX_VALUE;
        TreeNode dummy = new TreeNode(MAX);
        dummy.left = root;
        todelete.add(MAX);
        List<TreeNode> res = new ArrayList<>();
        helper(dummy, res, todelete);
        return res;
    }

    private TreeNode helper(TreeNode node, List<TreeNode> res, Set<Integer> todelete) {
        if (node == null) {
            return null;
        }

        TreeNode left = helper(node.left, res, todelete);
        TreeNode right = helper(node.right, res, todelete);

        if (todelete.contains(node.val)) {
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
