package leetcode0617;
import utils.*;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return helper(t1, t2);
    }

    private TreeNode helper(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        int val = t1.val + t2.val;
        TreeNode node = new TreeNode(val);
        node.left = helper(t1.left, t2.left);
        node.right = helper(t1.right, t2.right);
        return node;
    }
}
