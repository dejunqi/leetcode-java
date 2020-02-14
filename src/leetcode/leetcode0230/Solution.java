package leetcode0230;

import utils.TreeNode;

import java.util.Stack;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int res = -1;
        while (true) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                TreeNode node = stack.pop();
                k--;
                if (k == 0) {
                    res = node.val;
                    break;
                }
                cur = node.right;
            }
        }
        return res;
    }
}
