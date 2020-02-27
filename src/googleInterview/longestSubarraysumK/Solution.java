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
        int sum = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, -1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer floorKey = map.floorKey(sum - k);
            Integer ceilingKey = map.ceilingKey(sum - k);
            if (floorKey != null) {
//                res = Math.max(res, i - map.get(floorKey));
                if (i - map.get(floorKey) > res) {
                    System.out.println(i + ", " + map.get(floorKey));
                    res = i - map.get(floorKey);
                }
            }
            if (ceilingKey != null) {
                if (i - map.get(ceilingKey) > res) {
                    System.out.println(i + ", " + map.get(ceilingKey));
                    res = i - map.get(ceilingKey);
                }
            }
            map.put(sum, map.getOrDefault(sum , i));
        }
        return res;
    }


    public void test() {
        int[] case1 = {1, 3, 2, 5, 0, 2, 3, 1, 1, 1, 1, 9, 3, 3, 2};
//        System.out.println(longestSubarray(case1, 8));
        int[] case2 = {9, 1, 6, 1, -3, -4, 0, 1, 2, 3, 4, 5, 2, 9, 1, 6, -6, -1, 8};
         System.out.println(longestSubarray2(case2, 8));
    }

}
