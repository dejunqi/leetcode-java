package leetcode0518;

public class Solution {
    public int change(int amount, int[] coins) {

        int[][] cache = new int[amount + 1][coins.length];
        for (int i = 0; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                cache[i][j] = -1;
            }
        }

        return helper(amount, coins, cache, 0);

    }



    // dp
    public int change2(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins.length == 0) return 0;
        int len = coins.length;
        int[] dp = new int[amount + 1];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[j] = 1;
                } else {
                    if (j - coins[i] >= 0) {
                        dp[j] += dp[j - coins[i]];
                    }
                }
            }
        }

        return dp[amount];
    }



    private int helper(int amount, int[] coins, int[][] cache, int idx) {


        if (amount < 0) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }


        if (cache[amount][idx] > -1) {
            return cache[amount][idx];
        }

        int res = 0;
        for (int i = idx; i < coins.length; i++) {
            res += helper(amount - coins[i], coins, cache, i);
        }
        cache[amount][idx] = res;
        return res;
    }

    public void test() {
        int amount = 5;
        int[] coins = {1, 2, 5};
        int res = change(amount, coins);
        System.out.println(res);
    }
}