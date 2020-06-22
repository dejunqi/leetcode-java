package otherTopics.longestCommonSubstring;

import java.util.Arrays;

// longest common substring
public class Solution {

    public int longgestCommonSubstring(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        int idx1 = 0, idx2 = 0;
        String res = "";
        int maxlen = 0;
        for (int i = 1; i < len1 + 1; i++) {
            if (s1.charAt(i - 1) == s2.charAt(0)) {
                dp[i][1] = 1;
                maxlen = 1;
            }
        }

        for (int j = 1; j < len2; j++) {
            if (s2.charAt(j - 1) == s1.charAt(0)) {
                dp[1][j] = 1;
                maxlen = 1;
            }
        }

        for (int i = 2; i < len1 + 1; i++) {
            for (int j = 2; j < len2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxlen) {
                        maxlen = dp[i][j];
                        idx1 = i - 1;
                        idx2 = j - 1;
                    }
                }
            }
        }

        System.out.println(res);
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(idx1 + ", " + idx2);
        StringBuilder sb = new StringBuilder();
        while (s1.charAt(idx1) == s2.charAt(idx2)) {
            sb.insert(0, s1.charAt(idx1));
            idx1--;
            idx2--;
        }
        res = sb.toString();
        System.out.println(res);
        return maxlen;
    }

    public void test() {
        String s1 = "abcdef";
        String s2 = "jkbcdfe";
        System.out.println(longgestCommonSubstring(s1, s2));
    }
}
