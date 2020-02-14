package leetcode0317;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    private int res;
    private int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public int shortestDistance(int[][] grid) {

        int row = grid.length, col = grid[0].length;
        int[][] cloneGrid = clone(grid);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int[][] tmp = clone(grid);
                    helper(grid, tmp, i, j); // BFS
                    update(cloneGrid, tmp, grid);
                }
            }
        }
        return res;
    }

    private void helper(int[][] grid, int[][] A, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[0];
            for (int[] d : dirs) {
                int r = x + d[0], c = y + d[1];
                if (r >= 0 && r < grid.length && c >= 0 && c < grid.length && grid[r][c] == 0 && A[r][c] == 0) {
                    A[r][c] = A[i][j] + 1;
                    queue.add(new int[] {r, c});
                }
            }
        }
    }

    private void update(int[][] cloneGrid, int[][] B, int[][] grid) {
        for (int i = 0; i < cloneGrid.length; i++) {
            for (int j = 0; j < cloneGrid[0].length; j++) {
                if (grid[i][j] == 0) {
                    cloneGrid[i][j] += B[i][j];
                    res = Math.min(res, cloneGrid[i][j]);
                }
            }
        }
    }

    private int[][] clone(int[][] grid) {
        int[][] copy = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
    }
}
