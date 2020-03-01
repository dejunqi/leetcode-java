package leetcode.leetcode1314;

import java.util.Arrays;

// https://leetcode.com/problems/matrix-block-sum/
public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int row = 0, col = 0;
        if (mat.length > 0 && mat[0].length > 0) {
            row = mat.length;
            col = mat[0].length;
        }
        int[][] dp = new int[row + 1][col + 1];
        int[][] anwser = new int[row][col];
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int r1 = i - K, c1 = j - K;
                int r2 = i + K, c2 = j + K;
                if (r1 < 0) {
                    r1 = 0;
                }
                if (c1 < 0) {
                    c1 = 0;
                }
                if (r2 >= row) {
                    r2 = row - 1;
                }
                if (c2 >= col) {
                    c2 = col - 1;
                }
                r1++;
                c1++;
                r2++;
                c2++;
                System.out.println(r1 + ", " + c1 + ", " + r2 + ", " + c2);
                anwser[i][j] = dp[r2][c2] - dp[r2][c1 - 1] - dp[r1 - 1][c2] + dp[r1 - 1][c1 - 1];
            }
        }

        for (int[] r : anwser) {
            System.out.println(Arrays.toString(r));
        }

        return anwser;
    }

    public void test() {
        int[][] mat = {{1,2,3}, {4,5,6},{7,8,9}};
        int K = 2;
        int[][] res = this.matrixBlockSum(mat, K);
    }
}
