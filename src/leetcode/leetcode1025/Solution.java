package leetcode.leetcode1025;

import java.util.Arrays;

public class Solution {
    public boolean divisorGame(int N) {
        Boolean[] memo = new Boolean[N + 1];
        Arrays.fill(memo, null);
        return helper(N, memo, 0);
    }

    private boolean helper(int N, Boolean[] memo, int player) {
        if (N == 1) {
            return player != 0;
        }
        if (memo[N] != null) {
            return memo[N];
        }
        boolean cur = false;
        for (int x = 1; x < N; x++) {
            if (N % x == 0) {
                if (helper(N - x, memo, 1 - player)) {
                    cur = true;
                    break;
                }
            }
        }
        memo[N] = cur;
        return cur;
    }

    public void test() {
        System.out.println(this.divisorGame(3));
    }
}
