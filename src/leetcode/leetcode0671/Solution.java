package leetcode0671;

import leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int findSecondMinimumValue(TreeNode root) {

        int maxValue = Integer.MAX_VALUE;
        Integer a = null, b = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (a == null) {
                a = cur.val;
            } else if (cur.val > a && (b == null || cur.val <= b)) {
                b = cur.val;
                continue;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        if (b == null) {
            return -1;
        }
        return b;
    }

    public void test() {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(findSecondMinimumValue(n1));
    }
}



