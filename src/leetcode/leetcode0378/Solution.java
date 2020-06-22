package leetcode0378;

import java.util.PriorityQueue;

public class Solution {
    private class Pair {
        int val;
        int r;
        int c;
        Pair(int val, int r, int c) {
            this.val = val;
            this.r = r;
            this.c = c;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            queue.offer(new Pair(matrix[i][0], i, 0));
        }

        int res = -1;
        while (!queue.isEmpty() && k > 0) {
            Pair p = queue.poll();
            res = p.val;
            k--;
            int i = p.r;
            int j = p.c;
            if (j + 1 < col) {
                queue.offer(new Pair(matrix[i][j + 1], i, j + 1));
            }
        }
        return res;
    }
}
