package leetcode.leetcode0297;


import leetcode.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("#");
            } else {
                sb.append(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
            sb.append(",");
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] datas = data.split(",");
        TreeNode[] nodes = new TreeNode[datas.length];
        for (int i = 0; i < datas.length; i++) {
            if (!datas[i].equals("#")) {
                nodes[i] = new TreeNode(Integer.parseInt(datas[i]));
            }
        }

        int num = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) {
                num++;
            } else {
                int l = 2 * (i - num) + 1;
                int r = 2 * (i - num) + 2;
                nodes[i].left = nodes[l];
                nodes[i].right = nodes[r];
            }
        }
        return nodes[0];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
