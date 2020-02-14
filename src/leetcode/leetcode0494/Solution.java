package leetcode0494;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {

        Map<String, Integer> cache = new HashMap<>();
        return helper(nums, S, cache, 0);
    }

    private int helper(int[] nums, int target, Map<String, Integer> cache, int idx) {
        if (idx > nums.length) {
            return 0;
        }

        if (idx == nums.length) {
            return target == 0 ? 1 : 0;
        }

        String key = idx + "_" + target;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int left = helper(nums, target - nums[idx], cache, idx + 1);
        int right = helper(nums, target + nums[idx], cache, idx + 1);

        int res = left + right;
        cache.put(key, res);
        return res;

    }
}