package leetcode0410;

public class Solution {
    public int splitArray(int[] nums, int m) {
        int[][] memo = new int[nums.length + 1][m + 1];
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        return helper(sums, 0, m, memo);
    }


    private int helper(int[] sums, int idx, int m, int[][] memo) {
        int n = sums.length;
        if (m == 1) {
            return sums[n - 1] - sums[idx];
        }

        if (memo[idx][m] != 0) {
            return memo[idx][m];
        }

        int res = sums[n - 1] + 1;
        for (int i = idx; i < n - 2; i++) {
            int left = sums[i + 1] - sums[idx];
            int right = helper(sums, i + 1, m - 1, memo);
            res = Math.min(res, Math.max(left, right));
        }
        memo[idx][m] = res;
        return res;
    }
}