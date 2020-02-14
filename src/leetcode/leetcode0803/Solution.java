package leetcode0803;

import java.util.*;

public class Solution {

    private int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int row = grid.length, col = grid[0].length;
        for (int[] hit : hits) {
            int i = hit[0], j = hit[1];
            grid[i][j] -= 1;
        }

        for (int j = 0; j < col; j++) {
            helper(0, j, grid);
        }

        int[] res = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int[] hit = hits[i];
            int x = hit[0], y = hit[1];
            grid[x][y] += 1;
            if (grid[x][y] == 1 && isConnected(x, y, grid)) {
                res[i] += helper(x, y, grid) - 1;
            }
        }
        return res;
    }

    private int helper(int i, int j, int[][] grid) {
        int row = grid.length, col = grid[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        int res = 1;
        for (int[] d : dirs) {
            int r = i + d[0], c = j + d[1];
            res += helper(r, c, grid);
        }
        return res;
    }

    private boolean isConnected(int i, int j, int[][] grid) {
        if (i == 0 || grid[i][j] == 2) {
            return true;
        }
        for (int[] d : dirs) {
            int r = i + d[0], c = j + d[1];
            if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 2) {
                return true;
            }
        }
        return false;
    }

    public void test() {
        int[][] grid = {{1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
        int[][] hits = {{1, 0}, {1, 4}};
        int[] res = this.hitBricks(grid, hits);
        System.out.println(Arrays.toString(res));
    }
}
