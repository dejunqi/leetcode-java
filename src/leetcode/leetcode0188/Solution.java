package leetcode0188;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }
        if (k > n / 2) {
            return unlimitedTransactionCase(prices);
        }
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i < k + 1; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1];
                for (int m = 0; m < j; m++) {
                    dp[i][j] = Math.max(dp[i][j], prices[j] - prices[m] + dp[i - 1][m]);
                }
            }
        }
        return dp[k][n - 1];
    }

    private int unlimitedTransactionCase(int[] prices) {
        int res = 0;
        int curmin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > curmin) {
                res += prices[i] - curmin;
            }
            curmin = prices[i];
        }
        return res;
    }
}
