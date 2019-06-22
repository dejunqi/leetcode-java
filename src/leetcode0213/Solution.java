package leetcode0213;

public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len > 0 ? nums[0] : 0;
        }

        int[] memoA = new int[len];
        int[] memoB = new int[len];

        return Math.max(helper(nums, memoA, 0, len - 2), helper(nums, memoB, 1, len - 1));
    }

    private int helper(int[] nums, int[] memo, int i, int end) {
        if (i >= end + 1) {
            return 0;
        }

        if (memo[i] > 0) {
            return memo[i];
        }

        return Math.max(nums[i] + helper(nums, memo, i + 2, end), helper(nums, memo, i + 1, end));
    }

    public void test() {
        int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        System.out.println(rob(nums));
    }

}


