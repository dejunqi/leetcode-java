package leetcode.leetcode0296;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        return minDist(rows) + minDist(cols);
    }

    private int minDist(List<Integer> points) {
        int len = points.size();
        if (len == 0) {
            return 0;
        }

        Collections.sort(points);
        int median = 0;
        int mid = (len - 1) / 2;
        if (len % 2 != 0) {
            median = points.get(mid);
        } else {
            median = (points.get(mid) + points.get(mid + 1)) / 2;
        }

        int res = 0;
        for (Integer p : points) {
            res += Math.abs(p - median);
        }

        return res;
    }
}
