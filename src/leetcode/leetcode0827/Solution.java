package leetcode0827;

public  class Solution {

    private int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int largestIsland(int[][] grid) {
        int res = 0;
        int row = grid.length, col = grid[0].length;
        boolean hasZeor = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    hasZeor = true;
                    grid[i][j] = 1;
                    boolean[][] visited = new boolean[row][col];
                    res = Math.max(res, helper(grid, visited, i, j));
                    if (res == row * col) {
                        return res;
                    }
                    grid[i][j] = 0;
                }
            }
        }

        return hasZeor ? res : row * col;
    }

    private int helper(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        int cur = 1;
        for (int[] d : dirs) {
            cur += helper(grid, visited, i + d[0], j + d[1]);
        }
        return cur;
    }

    public void test() {
        int[][] grid = {{1, 1}, {1, 0}};
        int res = largestIsland(grid);
        System.out.println(res);
    }
}