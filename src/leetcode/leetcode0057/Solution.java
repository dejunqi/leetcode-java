package leetcode.leetcode0057;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            int s = interval[0], e = interval[1];
            if (e < newInterval[0]) {
                list.add(interval);
            }else if (s > newInterval[1]) {
                list.add(newInterval);
                newInterval = interval;
            } else {
                newInterval[0] = Math.min(s, newInterval[0]);
                newInterval[1] = Math.max(e, newInterval[1]);
            }
        }

        list.add(newInterval);

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
