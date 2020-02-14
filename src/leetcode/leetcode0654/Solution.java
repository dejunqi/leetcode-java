package leetcode0654;
import utils.*;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        return helper(nums, l, r);
    }


    private TreeNode helper(int[] nums, int l, int r) {
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        if (l > r) {
            return null;
        }
        int maxIdx = findMax(nums, l, r);
        TreeNode root = new TreeNode(nums[maxIdx]);
        TreeNode left = helper(nums, l, maxIdx - 1);
        TreeNode right = helper(nums, maxIdx + 1, r);
        root.left = left;
        root.right = right;
        return root;
    }

    private int findMax(int[] nums, int l, int r) {
        int val = Integer.MIN_VALUE;
        int idx = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > val) {
                idx = i;
                val = nums[i];
            }
        }
        return idx;
    }

    public void test() {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = constructMaximumBinaryTree(nums);
//        int idx = findMax(nums, 0, nums.length - 1);
//        System.out.println(idx);
        System.out.println(root.val);
    }
}
