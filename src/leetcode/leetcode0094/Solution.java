package leetcode0094;
import utils.TreeNode;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }
        helper(res, node.left);
        res.add(node.val);
        helper(res, node.right);
    }
}
