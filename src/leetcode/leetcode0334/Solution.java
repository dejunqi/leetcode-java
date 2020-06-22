package leetcode.leetcode0334;

public class Solution {
    public boolean increasingTriplet(int[] nums) {

        if (nums.length < 3) {
            return false;
        }

        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for (int val : nums) {
            if (val < a) {
                a = val;
            } else if (val < b) {
                b = val;
            } else {
                return true;
            }
        }
        return false;
    }

    public void test() {
        int[] nums = {2,1,5,0,3};
        System.out.println(this.increasingTriplet(nums));
    }
}
