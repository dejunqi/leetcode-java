package leetcode.leetcode0746;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len < 3) {
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[len + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= len; i++) {
            int val = i < len ? cost[i] : 0;
            dp[i] = val + Math.min(dp[i - 1], dp[i - 2]);
        }
        return dp[len];
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