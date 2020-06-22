package leetcode0337;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map);
    }

    private int helper(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        // case1 : rob this hose
        int case1 = node.val;
        if (node.left != null) {
            case1 += helper(node.left.left, map) + helper(node.left.right, map);
        }
        if (node.right != null) {
            case1 += helper(node.right.left, map) + helper(node.right.right, map);
        }

        // do not rob this house
        int case2 = helper(node.left, map) + helper(node.right, map);
        int res = Math.max(case1, case2);
        map.put(node, res);
        return res;
    }
}
