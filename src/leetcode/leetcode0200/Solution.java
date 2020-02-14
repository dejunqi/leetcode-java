package leetcode0200;

public class Solution {

    private int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    helper(grid, visited, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void helper(char[][] grid, boolean[][] visited, int i, int j) {
        int row = grid.length, col = grid[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || grid[i][j] == '0') {
            return;
        }

        visited[i][j] = true;
        for (int[] d : dirs) {
            int r = i + d[0], c = j + d[1];
            helper(grid, visited, r, c);
        }
    }
}
