package leetcode0951;
import leetcode.utils.TreeNode;

public class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        // same tree
        boolean case1 = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        // symetric case
        boolean case2 = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        return case1 || case2;

    }
}
