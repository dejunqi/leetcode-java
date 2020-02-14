package leetcode0463;

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int res = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == 1) {
                    res += 4;
                    for (int[] d : dirs) {
                        int r = i + d[0];
                        int c = j + d[1];
                        if (r < row && c < col && r >= 0 && c >= 0 && grid[r][c] == 1) {
                            res -= 1;
                        }
                    }
                }
            }
        }

        return res;
    }
}