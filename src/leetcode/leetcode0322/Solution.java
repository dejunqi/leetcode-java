package leetcode0322;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private int MAX = Integer.MAX_VALUE;

    // BFS
    public int coinChange(int[] coins, int amount) {

        Queue<Integer> queue = new LinkedList<>();
        int step = 0;
        queue.add(0);
        boolean[] visited = new boolean[amount + 1];

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int curnum = queue.poll();
                if (curnum == amount) {
                    break;
                }
                for (int j = 0; j < coins.length; j++) {
                    int nextnum = curnum + coins[j];
                    if (nextnum > amount || visited[nextnum]) {
                        continue;
                    }
                    visited[nextnum] = true;
                    queue.add(nextnum);
                }
            }
            step++;
        }

        return step;

    }


    // DFS
    public int coinChange2(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        int res = helper(coins, memo, amount);
        return res < MAX ? res : -1;
    }

    private int helper(int[] coins, int[] memo, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] > 0) {
            return memo[amount];
        }
        int len = coins.length;
        int res = MAX;
        for (int i = 0; i < len; i++) {
            int c = coins[i];
            if (amount - c >= 0) {
                int cur = helper(coins, memo, amount - c);
                if (cur < MAX) {
                    res = Math.min(res, 1 + cur);
                }
            }
        }
        memo[amount] = res;
        return res;
    }
}