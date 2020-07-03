package leetcode.leetcode0703;

public class Solution {
    public void test() {
//        int[] nums = {4, 5, 8, 2};
//        int[] testNums = {2, 5, 10, 9, 4};
//        int k = 3;
        int[] nums = {0};
        int[] testNums = {-1, 1, -2, -4, 3};
        int k = 2;

        KthLargest obj = new KthLargest(k, nums);

        for (int n : testNums) {
            System.out.println(obj.add(n));
        }

    }
}
