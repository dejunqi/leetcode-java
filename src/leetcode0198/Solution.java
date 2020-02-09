package leetcode0198;

import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {

        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(0, nums, memo);
    }

    private int helper(int idx, int[] nums, int[] memo) {
        if (idx >= nums.length) {
            return 0;
        }
        if (memo[idx] > -1) {
            return memo[idx];
        }

        int case1 = nums[idx] + helper(idx + 2, nums, memo);
        int case2 = helper(idx + 1, nums, memo);
        int res = Math.max(case1, case2);
        memo[idx] = res;
        return res;

    }
}
