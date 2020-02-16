package utils.practice;

import java.util.*;
import utils.TreeNode;

import javax.lang.model.type.ArrayType;

public class Solution {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        postOrder(root, map, list);
        return list;
    }

    private String postOrder(TreeNode node, Map<String, Integer> map, List<TreeNode> list) {
        if (node == null) {
            return "";
        }
        String left = postOrder(node.left, map, list);
        String right = postOrder(node.right, map, list);
        String key = node.val + "#" + left + "#" + right;
        if (map.getOrDefault(key, 0) == 1) {
            list.add(node);
        }
        map.put(key, map.getOrDefault(key, 0) + 1);
        System.out.println(node.val + " -- " + key);
        for (String k : map.keySet()) {
            System.out.println("\t" + k + ": " + map.get(k));
        }
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

        n1.left = n2; n1.right = n3;
        n2.left = n4;
        n3.left = n5; n3.right = n6;
        n5.left = n7;
        List<TreeNode> list = findDuplicateSubtrees(n1);
        for (TreeNode n : list) {
            System.out.println(n.val);
        }
    }
}
