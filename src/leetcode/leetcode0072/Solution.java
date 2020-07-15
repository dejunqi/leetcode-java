package leetcode.leetcode0072;

import sun.lwawt.macosx.CSystemTray;

import java.util.Arrays;

public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1 + 1; i++) {
            for (int j = 0; j < len2 + 1; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0) {
                        dp[0][j] = j;
                    }
                    if (j == 0) {
                        dp[i][0] = i;
                    }
                } else {
                    if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[len1][len2];

    }


    public void test() {
        String word1 = "horse";
        String word2 = "ros";
//        String word1 = "intention";
//        String word2 = "execution";
        int res = minDistance(word1, word2);
        System.out.println(res);
    }
}
