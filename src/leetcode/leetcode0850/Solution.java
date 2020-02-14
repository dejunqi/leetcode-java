package leetcode0850;

import java.util.*;

public class Solution {

    public int rectangleArea(int[][] rectangles) {

        int M = (int) Math.pow(10, 9) + 7;
        long res = 0;

        List<int[]> recList = new ArrayList<>();
        for (int[] rec : rectangles) {
            addRectangle(recList, rec, 0);
        }
        for(int[] rec: recList) {
            res += ((long)(rec[2]-rec[0])*(long)(rec[3]-rec[1]))% M;
            res %= M;
        }
        return (int) res;
    }

    private void addRectangle(List<int[]> reclist, int[] cur, int idx) {
        if (idx >= reclist.size()) {
            reclist.add(cur);
            return;
        }

        int[] pre = reclist.get(idx);


        // no overlap
        if (cur[0] >= pre[2] || cur[2] <= pre[0] || cur[1] >= pre[3] || cur[3] <= pre[1]) {
            addRectangle(reclist, cur, idx + 1);
            return;
        }


        if (cur[0] < pre[0]) {
            int[] newRec = {cur[0], cur[1], pre[0], cur[3]};
            addRectangle(reclist, newRec, idx + 1);
        }

        if (cur[2] > pre[2]) {
            int[] newRec = {pre[2], cur[1], cur[2], cur[3]};
            addRectangle(reclist, newRec, idx + 1);
        }

        if (cur[1] < pre[1]) {
            int[] newRec = {Math.max(pre[0], cur[0]),cur[1], Math.min(pre[2], cur[2]), pre[1]};
            addRectangle(reclist, newRec, idx + 1);
        }

        if (cur[3] > pre[3]) {
            int[] newRec = {Math.max(cur[0], pre[0]), pre[3], Math.min(pre[2], cur[2]), cur[3]};
            addRectangle(reclist, newRec, idx + 1);
        }
    }


    public void test() {
//        int[][] rects = {{0,0,2,2},{1,0,2,3},{1,0,3,1}};
        int[][] rects = {{49,40,62,100},{11,83,31,99},{19,39,30,99}};
        int res = rectangleArea(rects); // expected 1584
        System.out.println(res);
    }
}
