package leetcode0572;

import leetcode.utils.TreeNode;

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if ((s == null && t != null) || (s != null && t == null)) {
            return false;
        }
        if (isSameTree(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }


    private boolean isSameTree(TreeNode p1, TreeNode p2) {
        if (p1 == null || p2 == null) {
            return p1 == p2;
        }
        if (p1.val != p2.val) {
            return false;
        }
        return isSameTree(p1.left, p2.left) && isSameTree(p1.right, p2.right);
    }



    private String postOrder(TreeNode node) {
        if (node == null) {
            return "#";
        }
        String left = postOrder(node.left);
        String right = postOrder(node.right);
        return node.val + "," + left + "," + right;
    }
}
