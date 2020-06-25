package leetcode.leetcode0056;

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] res = new int[intervals.length][2];
        int idx = 0;

        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[0] > prev[1]) {
                res[idx] = prev;
                prev = cur;
            } else {
                int min = Math.min(cur[0], prev[0]);
                int max = Math.max(cur[1], prev[1]);
                prev = new int[] {min, max};
            }
        }
        res[idx] = prev;
        return Arrays.copyOfRange(res, 0, idx + 1);
    }


    public void test() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }
}
