package leetcode.leetcode0134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int cur = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            cur += diff;
            if (cur < 0) {
                cur = 0;
                res = i + 1;
            }
        }

        return total >= 0 ? res : -1;
    }
}
