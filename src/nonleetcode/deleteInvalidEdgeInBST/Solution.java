package nonleetcode.deleteInvalidEdgeInBST;

import utils.TreeNode;

/*
       7
     /  \
    5    9
    /\  /
   3   8

As seen in above, there is an invalid edge in a binary search tree, find it and remove it

* */

public class Solution {
    final int MAX = Integer.MAX_VALUE;
    final int MIN = Integer.MIN_VALUE;
    public void deleteInvalidEdge(TreeNode root) {
        deleteHelper(root, MIN, MAX);
    }

    private TreeNode deleteHelper(TreeNode node, int leftParent, int rightParent) {

        if (node == null || node.val <= leftParent || node.val >= rightParent) {
            return null;
        }

        TreeNode left = deleteHelper(node.left, leftParent, node.val);
        TreeNode right = deleteHelper(node.right, node.val, rightParent);
        node.left = left;
        node.right = right;
        return node;
    }

    public boolean validate(TreeNode root) {
        return validateHelper(root, MIN, MAX);
    }

    private boolean validateHelper(TreeNode node, int leftParent, int rightParent) {
        if (node == null) {
            return true;
        }
        if (node.val <= leftParent || node.val >= rightParent) {
            return false;
        }
        return validateHelper(node.left, leftParent, node.val) && validateHelper(node.right, node.val, rightParent);
    }

    /**
     *        7
     *      /  \
     *     5    9
     *     /\  /
     *    3   8
     */

    public void test() {
        TreeNode n7 = new TreeNode(7);
        TreeNode n5 = new TreeNode(5);
        TreeNode n9 = new TreeNode(9);
        TreeNode n3 = new TreeNode(3);
        TreeNode n8 = new TreeNode(8);
        n7.left = n5;
        n7.right = n9;
        n5.left = n3;
        n5.right = n8;
        n9.left = n8;

        System.out.println(validate(n7));
        deleteInvalidEdge(n7);
        System.out.println(validate(n7));
    }
}
