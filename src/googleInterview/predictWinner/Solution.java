package googleInterview.predictWinner;

/*
拿纸牌游戏， 纸牌上面有值，比如说 100， 1， -1， 2， 200， 1. 然后两个人轮流拿，直到拿完。 但是每次只能拿从左边数起的前一个到两个数，
大家都最优策略，问最后第一个人能拿多少分。
思路：dp存当前人比另一个人能多拿的数，从后往前拿，每次看三个[谁能给个解法链接]
https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/类似题目

这个是一个蛮经典的dp问题，lintcode上也有类似的题目 https://www.lintcode.com/problem/coins-in-a-line-ii/description
*/

import java.util.Arrays;

/*
拿纸牌游戏， 纸牌上面有值，比如说 100， 1， -1， 2， 200， 1. 然后两个人轮流拿，直到拿完。 但是每次只能拿从左边数起的前一个到两个数，
大家都最优策略，问最后第一个人能拿多少分。
思路：dp存当前人比另一个人能多拿的数，从后往前拿，每次看三个[谁能给个解法链接]
https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/类似题目

这个是一个蛮经典的dp问题，lintcode上也有类似的题目 https://www.lintcode.com/problem/coins-in-a-line-ii/description
*/
public class Solution {

    public boolean canWin(int[] nums) {
        if (nums.length <= 3) {
            return true;
        }
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int sum = 0;
        for (int val : nums) {
            sum += val;
        }
        return helper(nums, sum, memo, 0) * 2 >= sum;
    }

    private int helper(int[] nums, int sum, int[] memo, int idx) {
        if (idx >= nums.length || sum <= 0) {
            return 0;
        }
        if (idx == nums.length - 1) {
            return nums[idx];
        }

        if (memo[idx] > -1) {
            return memo[idx];
        }

        int case1 = 0, case2 = 0, case3 = 0;
        int target = sum - nums[idx];
        case1 = sum - helper(nums, target, memo, idx + 1);

        if (idx + 1 < nums.length) {
            target -= nums[idx + 1];
            case2 = sum - helper(nums, target, memo, idx + 2);
        }

        if (idx + 2 < nums.length) {
            target -= nums[idx + 2];
            case3 = sum - helper(nums, target, memo, idx + 3);
        }

        int res = Math.max(case1, Math.max(case2, case3));
        memo[idx] = res;
        return res;
    }
}




