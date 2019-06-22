package leetcode0647;

public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[] res = {0};
        for (int i = 0; i < n; i++) {
            palindromeCount(s, i, i, res);
            palindromeCount(s, i, i + 1, res);

        }
        return res[0];
    }

    private void palindromeCount(String s, int l, int r, int[] res) {
        int n = s.length();
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            res[0] += 1;
            l -= 1;
            r += 1;
        }
    }
}
