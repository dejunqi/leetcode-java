package leetcode0486;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        if (len % 2 == 0) {
            return true;
        }

        Map<String, Integer> memo = new HashMap<>();
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int score = helper(nums, 0, len - 1, sum, memo);
        return 2 * score >= sum;
    }

    private int helper(int[] nums, int l, int r, int sum, Map<String, Integer> memo) {
        String key = l + "," + r;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (l == r) {
            memo.put(key, nums[l]);
            return nums[l];
        }

        int s1 = sum - helper(nums, l + 1, r, sum - nums[l], memo);
        int s2 = sum - helper(nums, l, r - 1, sum - nums[r], memo);
        int res = Math.max(s1, s2);
        memo.put(key, res);
        return res;
    }

    public void test() {
        int[] nums = {0,0,7,6,5,6,1};
        System.out.println(PredictTheWinner(nums));
    }
}
