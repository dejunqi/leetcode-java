package leetcode0404;

import leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                System.out.println(node.val);
                if (node.left.left == null && node.left.right == null) {
                    res += node.left.val;
                }
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return res;
    }

    public void test() {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15= new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        n3.left = n9;
        n3.right = n20;
        n20.left = n15;
        n20.right = n7;
        int res = sumOfLeftLeaves(n3);
    }
}
