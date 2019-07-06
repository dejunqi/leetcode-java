package leetcode0497;


import java.util.Random;
import java.util.TreeMap;

public class Solution {
    int[][] rects;
    int sumArea;
    TreeMap<Integer, Integer> map;
    Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        map = new TreeMap<>();
        random = new Random();
        sumArea = 0;
        for (int i = 0; i < rects.length; i++) {
            int[] rec = rects[i];
            sumArea += Math.abs(rec[3] - rec[1] + 1) * Math.abs(rec[2] - rec[0] + 1);
            map.put(sumArea, i);
        }
    }

    public int[] pick() {

        int area = map.higherKey(random.nextInt(sumArea));
        int idx = map.get(area);
        int[] rec = this.rects[idx];
        int x1 = rec[0], y1 = rec[1], x2 = rec[2], y2 = rec[3];
        return new int[] {x1 + random.nextInt(x2 - x1 + 1), y1 + random.nextInt(y2 - y1 + 1)};
    }
}
