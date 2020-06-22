package leetcode.leetcode0931;

// [[-51,-35,74],[-62,14,-53],[94,61,-10]]

import java.util.Arrays;

public class Solution {
    public int minFallingPathSum(int[][] A) {
        int row = A.length, col = A[0].length;
        int[][] dp = new int[row][col];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0) {
                    dp[i][j] = A[i][j];
                } else {
                    int a = j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                    int b = dp[i - 1][j];
                    int c = j < col - 1 ? dp[i - 1][j + 1] : Integer.MAX_VALUE;
                    dp[i][j] = A[i][j] + Math.min(a, Math.min(b, c));
                }
                if (i == row - 1) {
                    res = Math.min(res, dp[i][j]);
                }
            }
        }
        for (int[] r : dp) {
            System.out.println(Arrays.toString(r));
        }
        return res;
    }

    public void test() {
        // int[][] A = {{-51,-35,74}, {-62,14,-53}, {94,61,-10}};
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        this.minFallingPathSum(A);
    }
}