package leetcode.leetcode0034;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {lowerBound(nums, target), upperBound(nums, target)};
    }

    private int lowerBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }
        return nums[r] == target ? r : -1;
    }

    private int upperBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(lowerBound(nums, 10 ));
        System.out.println(upperBound(nums, 10 ));
    }
}
