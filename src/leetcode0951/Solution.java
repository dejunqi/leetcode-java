package leetcode0951;
import utils.TreeNode;

public class Solution {


    public boolean flipEquiv(TreeNode p1, TreeNode p2) {
        if (p1 == null || p2 == null) {
            return p1 == p2;
        }

        if (p1.val != p2.val) {
            return false;
        }

        boolean case1 = flipEquiv(p1.left, p2.left) && flipEquiv(p1.right, p2.right);
        boolean case2 = flipEquiv(p1.left, p2.right) && flipEquiv(p1.right, p2.left);
        return case1 || case2;
    }

}
