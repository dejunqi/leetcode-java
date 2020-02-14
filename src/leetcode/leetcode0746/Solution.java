package leetcode0746;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {

        Map<String, Integer> memo = new HashMap<>();
        return Math.min(helper(cost, 0, 0, memo), helper(cost, 1, 0, memo));

    }

    private int helper(int[] cost, int idx, int curcost, Map<String, Integer> memo) {
        if (idx >= cost.length) {
            return curcost;
        }

        String key = curcost + "," + idx;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        curcost += cost[idx];
        int res = Math.min(helper(cost, idx + 1, curcost, memo), helper(cost, idx + 2, curcost, memo));
        memo.put(key, res);
        return res;
    }
}