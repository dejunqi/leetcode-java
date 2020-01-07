package leetcode0039;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> can = new ArrayList<>();
        helper(candidates, target, res, can, 0);
        return res;
    }

    private void helper(int[] candidates, int target,
                        List<List<Integer>> res, List<Integer> can, int idx) {
        if (idx >= candidates.length || target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(can));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            int num = candidates[i];
            can.add(num);
            helper(candidates, target - num, res, can, i);
            can.remove(can.get(can.size() - 1));
        }
    }
}
