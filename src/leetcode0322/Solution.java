package leetcode0322;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {
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
}