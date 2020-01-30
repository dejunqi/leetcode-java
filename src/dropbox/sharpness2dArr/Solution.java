package dropbox.sharpness2dArr;

import java.util.*;

public class Solution {

    public int sharpness(int[][] grid) {

        for(int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println();

        int m = grid.length, n = m == 0 ? 0 : grid[0].length;

        int[] dp = new int[n];

        for(int i = 0; i < m; i++) {
            dp[i] = grid[i][0];
        }

        for(int j = 1; j < n; j++) {

            int[] tmp = new int[n];

            for(int i = 0; i < m; i++) {
                if(i == 0) {
                    tmp[i] = Math.max(dp[i], dp[i + 1]) + grid[i][j];
                } else if (i == m - 1) {
                    tmp[i] = Math.max(dp[i - 1], dp[i]) + grid[i][j];
                } else {
                    tmp[i] = Math.max(dp[i-1], Math.max(dp[i], dp[i + 1])) + grid[i][j];
                }
            }

            dp = tmp;

        }

        System.out.println(Arrays.toString(dp));

        return dp[n - 1];
    }

    public int findSharpnessValue(int[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return -1;

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
        }

        for(int j = 1; j < n; j++) {
            for(int i = 0; i < m; i++) {
                //find the max sharpness from the left, upper left, and lower left path
                int pathPrev = dp[i][j-1];
                if(i > 0) {
                    pathPrev = Math.max(pathPrev, dp[i-1][j-1]);
                }
                if(i<m-1) {
                    pathPrev = Math.max(pathPrev, dp[i+1][j-1]);
                }

                dp[i][j] = Math.min(pathPrev, matrix[i][j]);
            }
        }

        for (int[] r : dp) {
            System.out.println(Arrays.toString(r));
        }

        int maxSharpness = Integer.MIN_VALUE;
        for(int i=0; i<m; i++) {
            maxSharpness = Math.max(maxSharpness, dp[i][n-1]);
        }

//        System.out.println(maxSharpness);

        return maxSharpness;

    }




    public void test () {

        int[][] grid = {{5, 7, 2},
                        {7, 5, 8},
                        {9, 1, 5}};
//        findSharpnessValue(grid);
        sharpness(grid);
    }

}
