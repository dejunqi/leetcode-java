package leetcode1057;


import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int m = workers.length;
        int n = bikes.length;
        int[] assignedWorkers = new int[m];
        boolean[] assignedBikes = new boolean[n];
        Arrays.fill(assignedWorkers, -1);
        Arrays.fill(assignedBikes, false);


        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });

        for (int i = 0; i < m; i++) {
            int[] wi = workers[i];
            for (int j = 0; j < n; j++) {
                int[] bj = bikes[j];
                int dist = Math.abs(bj[0] - wi[0]) + Math.abs(bj[1] - wi[1]);
                queue.offer(new int[] {dist, i, j});
            }
        }

        int cnt = 0;
        while (cnt < m) {
            int[] triple = queue.poll();
            int w = triple[2], b = triple[1];
            if (!assignedBikes[b] && assignedWorkers[w] == -1) {
                assignedWorkers[w] = b;
                assignedBikes[b] = true;
            }
        }

        return assignedWorkers;
    }
}
