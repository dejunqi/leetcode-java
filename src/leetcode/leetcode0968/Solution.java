package leetcode0968;

import utils.TreeNode;

public class Solution {
    private enum State {CAMERA, COVERED_NODE, LEAF};
    public int minCameraCover(TreeNode root) {
        int[] res = {0};
        State rootstate = helper(root, res);
        if (rootstate == State.CAMERA || rootstate == State.LEAF) {
            res[0] += 1;
        }
        return res[0];
    }

    private State helper(TreeNode node, int[] res) {
        if (node == null) {
            return State.COVERED_NODE;
        }
        State left = helper(node.left, res), right = helper(node.right, res);
        if (left == State.LEAF || right == State.LEAF) {
            res[0] += 1;
            return State.CAMERA;
        }
        if (left == State.CAMERA || right == State.CAMERA) {
            return State.COVERED_NODE;
        }
        return State.CAMERA;
    }
}
