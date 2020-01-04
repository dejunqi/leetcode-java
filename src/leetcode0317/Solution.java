package leetcode0317;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length, col = grid[0].length;
        int[][] reach = new int[row][col];
        int[][] distance = new int[row][col];
        int buildingNum = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    boolean[][] visited = new boolean[row][col];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});
                    int dist = 0;

                    while (!queue.isEmpty()) {
                        int n = queue.size();
                        dist += 1;
                        for (int k = 0; k < n; k++) {
                            int[] p = queue.poll();
                            for (int[] d : dirs) {
                                int r = p[0] + d[0];
                                int c = p[1] + d[1];
                                if (r < row && r >= 0 && c < col && c >= 0 && grid[r][c] == 0 && !visited[r][c]) {
                                    visited[r][c] = true;
                                    distance[r][c] += dist;
                                    reach[r][c] += 1;
                                    queue.offer(new int[] {r, c});
                                }
                            }
                        }
                    }
                }
            }
        }

        int MAX = Integer.MAX_VALUE;
        int res = MAX;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    res = Math.min(res, distance[i][j]);
                }
            }
        }

        return res < MAX ? res : -1;
    }
}
