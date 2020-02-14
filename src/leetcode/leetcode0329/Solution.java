package leetcode0329;

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        int[][] memo = new int[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res = Math.max(res, helper(matrix, memo, dirs, i, j));
            }
        }
        return res;
    }

    private int helper(int[][] matrix, int[][] memo, int[][] dirs, int i, int j) {
        int row = matrix.length, col = matrix[0].length;
        if (memo[i][j] > 0) {
            return memo[i][j];
        }

        int cur = 1;
        for (int[] d : dirs) {
            int r = i + d[0];
            int c = j + d[1];
            if (r >= 0 && r < row && c >= 0 && c < col && matrix[r][c] > matrix[i][j]) {
               cur = Math.max(cur, 1 + helper(matrix, memo, dirs, r, c));
            }
        }
        memo[i][j] = cur;
        return cur;
    }
}
