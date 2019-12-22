package leetcode0655;
import utils.*;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class Solution {

    public List<List<String>> printTree(TreeNode root) {
        int h = getHeight(root);
        int N = (int) Math.pow(2, h) - 1;
        List<List<String>> board = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                row.add("");
            }
            board.add(row);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, N/2));
        int numOfNodes = (int) Math.pow(2, h - 1);

        int l = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                TreeNode node = (TreeNode) p.getKey();
                int idx = (int) p.getValue();
                board.get(l).set(idx, Integer.toString(node.val));
                if (node.left != null) {
                    queue.offer(new Pair(node.left, idx - numOfNodes / 2));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, idx + numOfNodes / 2));
                }
            }
            numOfNodes /= 2;
            l++;
        }

        return board;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = 1 + getHeight(node.left);
        int right = 1 + getHeight(node.right);
        return Math.max(left, right);
    }

    public void test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        List<List<String>> res = printTree(n1);

    }
}
