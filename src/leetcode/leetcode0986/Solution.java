package leetcode0986;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        int m = A.length, n = B.length;
        while (i < m && j < n) {
            int[] a = A[i], b = B[j];
            int start = Math.max(a[0], b[0]);
            int end = Math.min(a[1], b[1]);
            if (end >= start) {
                list.add(new int[] {start, end});
            }

            if (a[1] == end) {
                i++;
            }
            if (b[1] == end) {
                j++;
            }
        }

        int[][] res = new int[list.size()][2];
        return list.toArray(res);
    }
}