package leetcode0366;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 1);
        return res;
    }

    private int helper(TreeNode node, List<List<Integer>> res, int layer) {
        if (node == null) {
            return 0;
        }

        while (res.size() < layer) {
            res.add(new ArrayList<>());
        }

        int left = 1 + helper(node.left, res, layer + 1);
        int right = 1 + helper(node.right, res, layer + 1);
        int idx = Math.max(left, right);
        res.get(idx - 1).add(node.val);
        return idx;
    }

    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        List<List<Integer>> res = findLeaves(node1);
        System.out.println(res);
    }
}