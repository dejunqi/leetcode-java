package leetcode.leetcode0516;

public class Solution2 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] memo = new int[len][len];
        return helper(s, memo, 0, len - 1);
    }

    private int helper(String s, int[][] memo, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return 1;
        }
        if (memo[l][r] > 0) {
            return memo[l][r];
        }
        int cur = 0;
        if (s.charAt(l) == s.charAt(r)) {
            cur = helper(s, memo, l + 1, r - 1) + 2;
        } else {
            cur = Math.max(helper(s, memo, l + 1, r), helper(s, memo, l, r - 1));
        }
        memo[l][r] = cur;
        return cur;
    }

    public void test() {
        System.out.println(longestPalindromeSubseq("kbccab"));
    }
}
