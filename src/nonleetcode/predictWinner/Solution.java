package nonleetcode.predictWinner;

/*
拿纸牌游戏， 纸牌上面有值，比如说 100， 1， -1， 2， 200， 1. 然后两个人轮流拿，直到拿完。 但是每次只能拿从左边数起的前一个到两个数，
大家都最优策略，问最后第一个人能拿多少分。
思路：dp存当前人比另一个人能多拿的数，从后往前拿，每次看三个[谁能给个解法链接]
https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/类似题目

这个是一个蛮经典的dp问题，lintcode上也有类似的题目 https://www.lintcode.com/problem/coins-in-a-line-ii/description
*/

import java.util.Arrays;



public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] coins) {
        int sum = 0;
        for (int c : coins) {
            sum += c;
        }
        // int[] memo = new int[sum + 1];
        int[] memo = new int[coins.length + 1];
        Arrays.fill(memo, -1);

        int one = helper(coins, sum, 0, memo);
        int two = sum - one;
        return 2 * one > sum;
    }

    private int helper(int[] coins, int sum, int idx, int[] memo) {
        if (idx >= coins.length) {
            return 0;
        }

        if (memo[idx] != -1) {
            return memo[idx];
        }

        int first = coins[idx];
        int op1 = sum - helper(coins, sum - first, idx + 1, memo);
        int op2 = 0;
        if (idx + 1 < coins.length) {
            int second = coins[idx + 1];
            op2 = sum - helper(coins, sum - first - second, idx + 2, memo);
        }

        memo[idx] = Math.max(op1, op2);
        return memo[idx];
    }
}





