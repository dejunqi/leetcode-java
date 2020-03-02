package otherTopics.knapSackproblem;

import java.util.Arrays;

/**
 * 背包问题描述：
 * 一个背包， 容量为C. 现有 N 个不同的物品, 编号为 0 ~ N - 1. 每件物品的体积为W[i], 价格为V[i]。
 * 问可以往背包中放入哪些物品， 使得在不超过背包容量的约束条件下， 总物品的价格最大。
 *
 * F(C, i) = Max(F(c, i - 1), F(C - w[i], i - 1) + V[i]0
 */

public class Solution {
    public int maxValue(int C, int[] W, int[] V) {
        int N = W.length;
        int[][] memo = new int[N][C + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return helper(C, W, V, memo, 0);
    }

    private int helper(int C, int[] W, int[] V, int[][] memo, int i) {
        if (i >= W.length) {
            return 0;
        }

        if (memo[i][C] != -1) {
            return memo[i][C];
        }
        int case1 = helper(C, W, V, memo, i + 1);
        int case2 = C - W[i] >= 0 ? V[i] + helper(C - W[i], W, V, memo, i + 1) : 0;
        memo[i][C] = Math.max(case1, case2);
        return memo[i][C];
    }

    public int maxValue2(int C, int[] W, int[] V) {
        int[][] dp = new int[W.length][C + 1];
        for (int c = 0; c <= C; c++) {
            if (c > W[0]) {
                dp[0][c] = V[0];
            }
        }

        for (int i = 1; i < W.length; i++) {
            for (int c = 1; c <= C; c++) {
                int case1 = dp[i - 1][c];
                int case2 = c - W[i] >= 0 ? dp[i - 1][c - W[i]] + V[i] : 0;
                dp[i][c] = Math.max(case1, case2);
            }
        }
        return dp[W.length - 1][C];
    }

    public void test() {
        int[] weights = {5, 4, 7, 2, 6};
        int[] values = {12, 3, 10, 3, 6};
        int capacity = 15; // output 25
        int res = maxValue2(capacity, weights, values);
        System.out.println(res);
    }
}
