package leetcode0486;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean PredictTheWinner(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        int sum = 0;
        for (int value : nums) {
            sum += value;
        }
        Map<String, Integer> memo = new HashMap<>();
        int score = helper(nums, sum, memo, 0, nums.length - 1);
        return score * 2 > sum;
    }

    // 定义一个函数, helper(num, l, r), 这个函数代表某个 player 在 nums 中在 l ~ r 范围内可以取得的最大分数.
    private int helper(int[] nums, int sum, Map<String, Integer> memo, int l, int r) {
        String key = l + "," + r;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (l == r) {
            memo.put(key, nums[l]);
            return nums[l];
        }

        // sum substract by the maximum score the other player can get if:
        int case1 = sum - helper(nums, sum - nums[l], memo, l + 1, r); // player one choose from left
        int case2 = sum - helper(nums, sum - nums[r], memo, l, r - 1); // player one choose from right
        int res = Math.max(case1, case2);
        memo.put(key, res);
        return res;
    }

    public void test() {
        int[] nums = {0,0,7,6,5,6,1};
        System.out.println(PredictTheWinner(nums));
    }
}
