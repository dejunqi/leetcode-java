package leetcode.leetcode1143;

import java.util.Arrays;

public class Solution {

    // 递归解法
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] memo = new int[len1][len2];
        for (int[] r : memo) {
            Arrays.fill(r, -1);
        }
        return helper(text1, text2, memo, len1 - 1, len2 - 1);
    }

    private int helper(String s1, String s2, int[][] memo, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (memo[i][j] > -1) {
            return memo[i][j];
        }
        int cur = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            cur = 1 + helper(s1, s2, memo, i - 1, j - 1);
        } else {
            cur = Math.max(helper(s1, s2, memo, i - 1, j), helper(s1, s2, memo, i, j - 1));
        }
        memo[i][j] = cur;
        return cur;
    }

    // DP解法
    public int longestCommonSubsequence2(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }

    public void test() {
        String s1 = "abcde", s2 = "ace";
        System.out.println(this.longestCommonSubsequence2(s1, s2));
    }
}
