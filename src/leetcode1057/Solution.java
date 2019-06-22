package leetcode1057;


import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {

        int n = workers.length;
        int m = bikes.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Set<Integer> assignedBike = new HashSet<>();

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });

        for (int i = 0; i < n; i++) {
            int[] worker = workers[i];
            for (int j = 0; j < m; j++) {
                int[] bike = bikes[j];
                int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                queue.add(new int[] {dist, i, j});
            }
        }


        while (assignedBike.size() < n) {
            int[] triple = queue.poll();
            int dist = triple[0], wokerIdx = triple[1], bikeIdx = triple[2];
            if (res[wokerIdx] == -1 && !assignedBike.contains(bikeIdx)) {
                res[wokerIdx] = bikeIdx;
                assignedBike.add(bikeIdx);
            }
        }


        return res;
    }
}
