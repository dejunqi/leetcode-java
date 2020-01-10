package leetcode0497;


import java.util.Random;
import java.util.TreeMap;

public class Solution {
    int[][] recs;
    int sumArea;
    TreeMap<Integer, Integer> map;
    Random rnd;

    public Solution(int[][] rects) {
        recs = rects;
        sumArea = 0;
        map = new TreeMap<>();
        rnd = new Random();
        for (int i = 0; i < rects.length; i++) {
            int[] rec = rects[i];
            sumArea += Math.abs(rec[3] - rec[1] + 1) * Math.abs(rec[2] - rec[0] + 1);
            map.put(sumArea, i);
        }
    }

    public int[] pick() {
        int area = map.higherKey(rnd.nextInt(sumArea));
        int idx = map.get(area);
        int[] rec = this.recs[idx];
        int x1 = rec[0], y1 = rec[1];
        int x2 = rec[2], y2 = rec[3];
        return new int[] {x1 + rnd.nextInt(x2 - x1 + 1), y1 + rnd.nextInt(y2 - y1 + 1)};
    }
}

