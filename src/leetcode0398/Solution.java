package leetcode0398;

import java.util.Random;

public class Solution {

    private int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int e = nums.length;
        Random rnd = new Random();
        int res = -1;
        int idx = -1;
        while (res != target) {
            idx = rnd.nextInt(e);
            res = nums[idx];
        }

        return idx;
    }
}
