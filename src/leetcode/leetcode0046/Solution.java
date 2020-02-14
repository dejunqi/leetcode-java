package leetcode0046;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> can = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(res, can, visited, nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> can, boolean[] visited, int[] nums) {
        if (can.size() == nums.length) {
            res.add(new ArrayList<>(can));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                can.add(nums[i]);
                helper(res, can, visited, nums);
                can.remove(can.size() - 1);
                visited[i] = false;
            }
        }
    }

    public void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = permute(nums);
        for (List<Integer> list : res) {
            for (Integer v : list) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}