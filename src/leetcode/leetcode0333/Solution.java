package leetcode0333;
import leetcode.utils.TreeNode;

public class Solution {

    private class Triple {
        int max;
        int min;
        int size;
        Triple(int size, int max, int min) {
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        int[] res = {0};
        helper(root, res);
        return res[0];
    }

    private Triple helper(TreeNode node, int[] res) {
        if (node == null) {
            return new Triple(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Triple left = helper(node.left, res);
        Triple right = helper(node.right, res);
        if (left.size == -1 || right.size == -1 || node.val <= left.max || node.val >= right.min) {
            return new Triple(-1, 0, 0);
        }
        int size = 1 + left.size + right.size;
        int max = Math.max(node.val, right.max);
        int min = Math.min(node.val, left.min);
        res[0] = Math.max(res[0], size);
        return new Triple(size, max, min);
    }
}
