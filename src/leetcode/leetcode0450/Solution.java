package leetcode0450;

import leetcode.utils.TreeNode;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode node = minNode(root.right);
                root.val = node.val;
                root.right = deleteNode(root.right, node.val);
            }
        }

        return root;
    }

    private TreeNode minNode(TreeNode node) {
        TreeNode cur = node;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
}
