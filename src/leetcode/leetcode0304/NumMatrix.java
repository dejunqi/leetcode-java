package leetcode.leetcode0304;

import java.util.Arrays;

public class NumMatrix {
    private int[][] dp;
    public NumMatrix(int[][] matrix) {
        int row = 0, col = 0;
        if (matrix.length > 0 && matrix[0].length > 0) {
            row = matrix.length;
            col = matrix[0].length;
        }

        dp = new int[row + 1][col + 1];
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int r1 = row1 + 1, c1 = col1 + 1, r2 = row2 + 1, c2 = col2 + 1;
        return dp[r2][c2] - dp[r2][c1 - 1] - dp[r1 - 1][c2] + dp[r1 - 1][c1 - 1];
    }
}
