package leetcode.leetcode0746;

import java.util.Arrays;

public class Solution2 {

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] memo = new int[len];
        Arrays.fill(memo, -1);
        return Math.min(helper(cost, memo, len - 1), helper(cost, memo, len - 2));
    }

    private int helper(int[] cost, int[] memo, int idx) {
        if (idx == 0 || idx == 1) {
            return cost[idx];
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }

        int case1 = cost[idx] + helper(cost, memo, idx - 1);
        int case2 = cost[idx] + helper(cost, memo, idx - 2);
        int curres = Math.min(case1, case2);
        memo[idx] = curres;
        return curres;
    }

    public void test() {
        int[][] testcase = {
                {10, 15, 20},
                {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
        };
        for (int[] cost : testcase) {
            System.out.println(minCostClimbingStairs(cost));
        }
    }
}
