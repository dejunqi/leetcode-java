package leetcode.leetcode0200;

public class Solution {

    private int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public int numIslands(char[][] grid) {

        int res = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return res;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    helper(i, j, grid, visited);
                    res += 1;
                }
            }
        }
        return res;
    }

    private void helper(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < grid.length && x >= 0 && y < grid[0].length && y >= 0 && grid[x][y] == '1' && !visited[x][y]) {
                helper(x, y, grid, visited);
            }
        }
    }

    public void test() {
        char[][] grid = {{'1','1','0','0','0'},
                         {'1','1','0','0','0'},
                         {'0','0','1','0','0'},
                         {'0','0','0','1','1'}};

        int res = numIslands(grid);
        System.out.println(res);
    }
}
