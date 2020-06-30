package leetcode.leetcode0236;

import apple.laf.JRSUIUtils;
import leetcode.utils.TreeNode;

import java.util.*;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root;
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        parent.put(root, null);
        queue.add(root);

        while ((!parent.containsKey(p) || !parent.containsKey(q)) && !queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                parent.put(cur.left, cur);
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                parent.put(cur.right, cur);
                queue.offer(cur.right);
            }
        }

        Set<TreeNode> set = new HashSet<>();
        set.add(p);
        while (p != null) {
            p = parent.get(p);
            set.add(p);
        }

        while (!set.contains(q)) {
            q = parent.get(q);
        }

        return q;

    }


    public void test() {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = a7;

        TreeNode lca = lowestCommonAncestor2(a1, a3, a6);
        System.out.println(lca.val);
    }
}
