package leetcode1066;


public class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int[] res = {Integer.MAX_VALUE};
        boolean[] assigned = new boolean[bikes.length];
        helper(workers, bikes, res, assigned, 0, 0);
        return res[0];
    }

    private void helper(int[][] workers, int[][] bikes, int[] res, boolean[] assigned, int idx, int dist) {
        if (idx >= workers.length) {
            res[0] = Math.min(res[0], dist);
            return;
        }

        if (dist > res[0]) {
            return;
        }

        for (int i = 0; i < bikes.length; i++) {
            if (!assigned[i]) {
                assigned[i] = true;
                int d = Math.abs(workers[idx][0] - bikes[i][0]) + Math.abs(workers[idx][1] - bikes[i][1]);
                helper(workers, bikes, res, assigned, idx + 1, dist + d);
                assigned[i] = false;
            }
        }
    }
}