package leetcode0973;

import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> {
            int d1 = p1[0] * p1[0] + p1[1] * p1[1];
            int d2 = p2[0] * p2[0] + p2[1] * p2[1];
            return d1 - d2;
        });

        for (int[] p : points) {
            queue.offer(p);
        }

        int[][] res = new int[K][2];
        int idx = 0;
        for (int i = 0; i < K; i++) {
            res[idx++] = queue.poll();
        }

        return res;
    }
}
