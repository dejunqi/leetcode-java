package leetcode.leetcode0075;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        int idx = 0;
        // 三个指针, p0 永远指向第一个0, idx, 永远跟在 p0前面 1 位
        // p2 永远指向 数目为 2 的元素的前一位(向左看的前一位)
        while (idx <= p2) {
            if (nums[idx] == 0) {
                swap(nums, idx, p0);
                p0++;
                idx++;
            } else if (nums[idx] == 2) {
                swap(nums, idx, p2);
                p2--;
            } else {
                idx++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void test() {
//        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] nums = {2, 0, 1};
//        int[] nums = {1, 2, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
