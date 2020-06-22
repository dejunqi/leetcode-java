package leetcode0662;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private class Pair {
        TreeNode node;
        int pos;
        Pair(TreeNode n, int i) {
            node = n;
            pos = i;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        int res = Integer.MIN_VALUE;

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int len = queue.size();
            int left = 0, right = 0;
            for (int i = 0; i < len; i++) {
                Pair p = queue.poll();
                TreeNode node = p.node;
                int idx = p.pos;
                if (i == 0) {
                    left = idx;
                }
                if (i == len - 1) {
                    right = idx;
                }
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * idx));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * idx + 1));
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public void test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        int res = widthOfBinaryTree(n1);
        System.out.println(res);
    }
}
