package leetcode.leetcode1155;

import java.util.Arrays;

public class Solution {
//    private int res = 0;
    final int mod = 1000000000 + 7;
    public int numRollsToTarget(int d, int f, int target) {
        int[][] memo = new int[d + 1][target + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        int res = helper(d, f, target, memo);
        return res;
    }

    private int helper(int d, int f, int target, int[][] memo) {
        if (d == 0) {
            if (target != 0) {
                return 0;
            }
            return 1;
        }

        if (memo[d][target] != -1) {
            return memo[d][target];
        }
        int cur = 0;
        for (int val = 1; val <= f; val++) {
            if (target >= val) {
                cur = (cur + helper(d - 1, f, target - val, memo)) % mod;
            } else {
                break;
            }
        }
        memo[d][target] = cur;
        return cur;
    }

    public void test() {
        int v = this.numRollsToTarget(30, 30, 500);
        System.out.println(v);
    }
}
