package leetcode0384;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    private int[] nums;
    private int[] shuffledNums;
    private Random rand;
    public Solution(int[] nums) {
        rand = new Random();
        this.nums = nums;
        shuffledNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            shuffledNums[i] = nums[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            int l = rand.nextInt(this.nums.length);
            int r = rand.nextInt(this.nums.length);
            swap(shuffledNums, l, r);
        }
        return shuffledNums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }
}

