package leetcode0395;

public class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        return helper(s, k, 0, n - 1);
    }

    private int helper(String s, int k, int l, int r) {
        if (l > r) {
            return 0;
        }

        int[] count = new int[26];
        int n = s.length();
        for (int i = l; i < r + 1; i ++) {
            count[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                char c = (char)(i + 'a');
                int idx = s.indexOf(c, l);
                int left = helper(s, k, l, idx - 1);
                int right = helper(s, k, idx + 1, r);
                return Math.max(left, right);
            }
        }

        return r - l + 1;
    }

    public void test() {
        String s = "ababbc";
        int res = longestSubstring(s, 2);
        System.out.println(res);
    }

}