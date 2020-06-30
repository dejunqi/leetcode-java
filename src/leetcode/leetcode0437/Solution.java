package leetcode0437;
import leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int[] res = {0};
        helper(root, sum, map, res, 0);
        return res[0];
    }

    private void helper(TreeNode node, int target, Map<Integer,
            Integer> map, int[] res, int cursum) {
        if (node == null) {
            return;
        }
        cursum += node.val;
        int value = cursum - target;
        res[0] += map.getOrDefault(value, 0);
        map.put(cursum, map.getOrDefault(cursum, 0) + 1);
        helper(node.left, target, map, res, cursum);
        helper(node.right, target, map, res, cursum);
        map.put(cursum, map.get(cursum) - 1);
    }
}
