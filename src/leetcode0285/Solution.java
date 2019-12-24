package leetcode0285;
import utils.TreeNode;

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode cur = root;
        TreeNode successor = null;

        while (cur != null) {
            if (p.val < cur.val) {
                successor = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return successor;
    }
}
