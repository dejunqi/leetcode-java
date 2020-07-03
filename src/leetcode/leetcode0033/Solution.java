package leetcode.leetcode0033;

public class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {return -1;}
        int p = searchPivot(nums, 0, len - 1);
        if (p == -1) {
            return binarySearch(nums, 0, len - 1, target);
        }
        int l = binarySearch(nums, 0, p - 1, target);
        if (l > -1) {
            return l;
        }
        return binarySearch(nums, p, len - 1, target);
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, r, target);
        } else {
            return binarySearch(nums, l, mid - 1, target);
        }
    }

    private int searchPivot(int[] nums, int l, int r) {
        if (l >= r) {
            return -1;
        }
        if (r - l == 1 && nums[l] > nums[r]) {
            return r;
        }

        int mid = l + (r - l) / 2;
        if (nums[l] < nums[mid]) {
            return searchPivot(nums, mid, r);
        } else {
            return searchPivot(nums, l, mid);
        }
    }

    public void test() {
//        int[] nums = {3, 4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {6, 7, 0, 1, 2, 3, 4, 5};
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {1};
        int idx = searchPivot(nums, 0, nums.length - 1);
        int res = search(nums, 3);
        System.out.println(idx + ", " + res);
    }
}
