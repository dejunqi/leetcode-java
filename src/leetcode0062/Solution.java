package leetcode0062;

public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[] dp = new int[m];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int tmp = 1;
            for (int j = 1; j < m; j++) {
                if (i == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j] + tmp;
                    tmp = dp[j];
                }
            }
        }
        return dp[m - 1];
    }

    public void test() {
        int m = 1;
        int n = 2;
        int res = uniquePaths(m, n);
        System.out.println(res);
    }
}
