package leetcode.leetcode0652;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        helper(map, res, root);
        return res;
    }

    private String helper(Map<String, Integer> map, List<TreeNode> res, TreeNode node) {
        if (node == null) {
            return "#";
        }

        String left = helper(map, res, node.left);
        String right = helper(map, res, node.right);
        String key = node.val + "," + left + "," + right;
        if (map.getOrDefault(key, 0) == 1) {
            res.add(node);
        }
        map.put(key, map.getOrDefault(key, 0) + 1);
        return key;
    }

    public void test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;

        n3.left = n5;
        n3.right = n6;
        n5.left = n7;


    }
}
