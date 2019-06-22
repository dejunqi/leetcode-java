package leetcode1066;


public class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean[] visited = new boolean[bikes.length];
        int[] res = {Integer.MAX_VALUE};
        helper(workers, bikes, visited, res, 0, 0);
        return res[0];
    }

    private void helper(int[][] workers, int[][] bikes, boolean[] visited, int[] res, int idx, int distance) {
        if (idx >= workers.length) {
            res[0] = Math.min(res[0], distance);
            return;
        }

        if (distance > res[0]) {
            return;
        }

        for (int i = 0; i < bikes.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            int d = distance + Math.abs(workers[idx][0] - bikes[i][0]) + Math.abs(workers[idx][1] - bikes[i][1]);
            helper(workers, bikes, visited, res, idx + 1, d);
            visited[i] = false;
        }
    }
}