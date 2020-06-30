package leetcode0092;
import leetcode.utils.TreeNode;

/*
* if node.val >= right-parent or node.val <= left-parent
*   false
* */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer leftParent, Integer rightParent) {
        if (node == null) {
            return true;
        }

        if ((rightParent != null && node.val >= rightParent)||
                (leftParent != null && node.val <= leftParent)) {
            return false;
        }


        boolean leftres = helper(node.left, leftParent, node.val);
        boolean righres = helper(node.right, node.val, rightParent);
        return leftres && righres;
    }
}
