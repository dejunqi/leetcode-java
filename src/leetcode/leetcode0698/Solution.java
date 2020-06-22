package leetcode.leetcode0698;

public class Solution {

    boolean[] visited;
    int target = 0;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = sum(nums);
        if (k == 0 || sum % k != 0) {
            return false;
        }
        target = sum / k;
        visited = new boolean[nums.length];
        return helper(nums, k, 0, 0, 0);
    }

    private boolean helper(int[] nums, int k, int cursum, int subsetLen, int idx) {

        if (k == 1) {
            return true;
        }

        if (nums.length - subsetLen < k - 1) {
            return false;
        }

        if (cursum == target) {
            return helper(nums, k - 1, 0, 0, 0);
        }

        for (int i = idx; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (helper(nums, k, cursum + nums[i], subsetLen + 1, i + 1)) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }

    private int sum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }

    public void test() {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        boolean res = canPartitionKSubsets(nums, k);
        System.out.println(res);
    }
}
