package leetcode0803;

public class Solution {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] res = new int[hits.length];
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] hit : hits) {
            grid[hit[0]][hit[1]] -= 1;
        }

        for (int i = 0; i < grid[0].length; i++) {
            helper(0, i, grid, dirs);
        }

        for (int k = hits.length - 1; k >= 0; k--) {
            int i = hits[k][0], j = hits[k][1];
            grid[i][j] += 1;
            if (grid[i][j] == 1 && isConnected(i, j, grid, dirs)) {
                res[k] = helper(i, j, grid, dirs) - 1;
            }
        }

        return res;
    }


    private int helper(int i, int j, int[][] grid, int[][] dirs) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        int res = 1;
        for (int[] d : dirs) {
            int r = i + d[0], c = j + d[1];
            res += helper(r, c, grid, dirs);
        }
        return res;
    }

    private boolean isConnected(int i, int j, int[][] grid, int[][] dirs) {
        if(i == 0) {
            return true;
        }

        for (int k = 0; k < 4; k++) {
            int r = i + dirs[k][0], c = j + dirs[k][1];
            if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 2) {
                return true;
            }
        }
        return false;
    }
}
