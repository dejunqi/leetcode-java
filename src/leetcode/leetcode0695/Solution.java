package leetcode.leetcode0695;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, helper(grid, i, j));
                }
            }
        }

        return res;

    }

    private int helper(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = -1;
        int cnt = 1;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] d : dirs) {
            int r = i + d[0];
            int c = j + d[1];

            if (r < grid.length && r >= 0 && c < grid[0].length && c >= 0 && grid[r][c] != -1) {
                cnt += helper(grid, r, c);
            }
        }
        return cnt;
    }
}

