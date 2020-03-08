package googleInterview.longestSubarraysumK;

import java.util.TreeMap;

// Longest Subarray having sum of elements almost k
public class Solution {
    // Without negative value
    public int longestSubarray(int[] nums, int k) {
        int i = 0, j = 0;
        int len = nums.length;
        int sum = 0;
        int res = 0;
        while (j < len) {
            while (j < len && sum <= k) {
                sum += nums[j];
                j++;
                if (j - i > res) {
                    System.out.println(i + ", " + j);
                    res = j - i;
                }
            }

            while (j < len && sum > k) {
                sum -= nums[i];
                i++;
            }
        }

        res = Math.max(res, j - i);
        return res;
    }

    // contains negative number
    public int longestSubarray2(int[] nums, int k) {
        // TODO:
        return -1;
    }


    public void test() {
        int[] case1 = {1, 3, 2, 5, 0, 2, 3, 1, 1, 1, 1, 9, 3, 3, 2};
//        System.out.println(longestSubarray(case1, 8));
        int[] case2 = {9, 1, 6, 1, -3, -4, 0, 1, 2, 3, 4, 5, 2, 9, 1, 6, -6, -1, 8};
         System.out.println(longestSubarray2(case2, 8));
    }

}
